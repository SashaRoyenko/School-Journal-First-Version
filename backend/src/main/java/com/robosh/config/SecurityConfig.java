package com.robosh.config;

import com.robosh.config.security.jwt.JwtConfigurer;
import com.robosh.config.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import static com.robosh.data.enumeration.Role.*;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenProvider jwtTokenProvider;

    private static final String ADMIN_ENDPOINT = "/admin/**";
    private static final String TEACHER_ENDPOINT = "/teacher/**";
    private static final String STUDENT_ENDPOINT = "/student/**";
    private static final String PARENT_ENDPOINT = "/parent/**";
    private static final String LOGIN_ENDPOINT = "/login";

    @Autowired
    public SecurityConfig(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//                .and()
//                .authorizeRequests()
//                .antMatchers("/user/save").permitAll()
//                .antMatchers("/").hasAuthority(ADMIN.name())
//                .antMatchers(LOGIN_ENDPOINT).permitAll()
//                .antMatchers(ADMIN_ENDPOINT).hasAuthority(ADMIN.name())
//                .antMatchers(TEACHER_ENDPOINT).hasAuthority(TEACHER.name())
//                .antMatchers(STUDENT_ENDPOINT).hasAuthority(STUDENT.name())
//                .antMatchers(PARENT_ENDPOINT).hasAuthority(PARENT.name())
//                .and()
//                .apply(new JwtConfigurer(jwtTokenProvider))
//                .and()
//                .logout();
    }
}