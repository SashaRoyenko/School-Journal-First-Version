package com.robosh.controller;

import com.robosh.data.enumeration.Role;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.HashSet;

import static com.robosh.common_routes.Routes.E_JOURNAL;
import static com.robosh.data.enumeration.Role.*;

@Controller
@RequestMapping(E_JOURNAL)
public class LoginController {

    @GetMapping("/login")
    public String loginPage()
    {
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
