package com.robosh.controller;

import com.robosh.config.security.jwt.JwtTokenProvider;
import com.robosh.data.dto.LoginDto;
import com.robosh.data.entity.User;
import com.robosh.exception.AuthenticationException;
import com.robosh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@Controller
@RestController
public class LoginController {

    private static final String TOKEN_HEADER = "Authorization";
    private static final String TOKEN_PREFIX = "Bearer ";
    private static final String ACCESS_CONTROL = "Access-Control-Expose-Headers";
    @SuppressWarnings("squid:S2068")
    private static final String MESSAGE_WRONG_PASSWORD = "Invalid password";
    private static final String MESSAGE_WRONG_LOGIN = "Invalid email";
    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserService userService;

    @Autowired
    public LoginController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    @PostMapping("/login")
    public void login(@RequestBody LoginDto loginDto, HttpServletResponse response) {
        response.setHeader(TOKEN_HEADER,
                TOKEN_PREFIX + getToken(loginDto));
        response.setHeader(ACCESS_CONTROL, TOKEN_HEADER);
    }

    private String getToken(LoginDto loginDto) {
        String email = loginDto.getEmail();
        if (userService.findByEmail(email).isPresent()) {
            try {
                return getAuthenticationToken(loginDto);
            } catch (BadCredentialsException e) {
                throw new AuthenticationException(MESSAGE_WRONG_PASSWORD);
            }
        } else {
            throw new AuthenticationException(MESSAGE_WRONG_LOGIN);
        }
    }

    private String getAuthenticationToken(LoginDto loginDto) {
        String email = loginDto.getEmail();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, loginDto.getPassword()));
        User user = userService.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User with email: " + email + " not found")
                );
        return jwtTokenProvider.createToken(email, user.getRole());
    }
}
