package org.krish.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")   //Same as what we've configured in SecurityAppConfig
    public String showLogin()
    {
        return "login";
    }
}
