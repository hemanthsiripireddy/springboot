package com.hemanth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    @GetMapping("/")
    public String showHome(){

        return "home";

    }
    @GetMapping("/leaders")
    public String showLeaders(){

        return "leaders";

    }

    @GetMapping("/admin")
    public String showAdmin(){

        return "admin";

    }
    @GetMapping("/access-denied")
    public String accessDenied(){

        return "access-denied";

    }

}
