package com.robosh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.robosh.common_routes.Routes.E_JOURNAL;

@Controller
//@RequestMapping(E_JOURNAL)
public class HomePageController {
    @GetMapping(E_JOURNAL +"/home")
    public String homePage() {
        return "home_page";
    }
}
