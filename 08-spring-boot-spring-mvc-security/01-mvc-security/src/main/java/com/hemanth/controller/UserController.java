package com.hemanth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {
    @GetMapping("/showMyLoginPage")
    public String showLoginPage(){

        return "login-form";

    }
}
