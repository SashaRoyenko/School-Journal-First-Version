package com.robosh.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashSet;

import static com.robosh.common_routes.Routes.*;
import static com.robosh.data.enumeration.Role.*;

@Controller
public class DefaultController {

    @GetMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = new HashSet<>(auth.getAuthorities());
        boolean isAdmin = authorities.contains(new SimpleGrantedAuthority(ADMIN.name()));
        boolean isStudent = authorities.contains(new SimpleGrantedAuthority(STUDENT.name()));
        boolean isParent = authorities.contains(new SimpleGrantedAuthority(PARENT.name()));
        boolean isTeacher = authorities.contains(new SimpleGrantedAuthority(TEACHER.name()));

        if (isAdmin) {
            return REDIRECT_URL + ADMIN_MAPPING;
        }
        if (isStudent) {
            return REDIRECT_URL + STUDENT_MAPPING;
        }
        if (isParent) {
            return REDIRECT_URL + PARENT_MAPPING;
        }
        if(isTeacher) {
            return REDIRECT_URL + TEACHER_MAPPING;
        }

        return "login";
    }
}
