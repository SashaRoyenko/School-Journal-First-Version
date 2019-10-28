package com.robosh.controller;

import com.robosh.data.entity.User;
import com.robosh.data.enumeration.Role;
import com.robosh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class MainController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getMain() {
        return SecurityContextHolder.getContext().getAuthentication().toString();
    }

    @PostMapping("/user/save")
    public void saveUser() {
        User user = new User();
        user.setFirstName("Admin");
        user.setSecondName("Admin");
        user.setLastName("Admin");
        user.setEmail("admin@admin.com");
        user.setPhone("+380982827486");
        user.setLogin("admin");
        user.setPassword("admin");
        user.setRole(Role.ADMIN);
        userService.save(user);
    }
}
