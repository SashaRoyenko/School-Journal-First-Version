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
            //todo replace all with urls
            return "home_page";
        }
        if (isStudent) {
            return "redirect:/taxi-kyiv/driver-account";
        }
        if (isParent) {
            return "redirect:/taxi-kyiv/driver-account";
        }
        if(isTeacher) {
            return "redirect:/taxi-kyiv/driver-account";
        }
        return "login";
    }
}
