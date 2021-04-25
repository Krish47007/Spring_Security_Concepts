package com.krish.springbootsecurity.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    //Should be accessible to everyone
    @GetMapping("/")
    public String home()
    {
        return "<h1>Welcome to Spring Security Project</h1>";
    }

    //Should be accessible to ADMIN and USER
    @GetMapping("/user")
    public String user()
    {
        return "<h1>Welcome USER</h1>";
    }

    //Should be accessible to ADMIN
    @GetMapping("/admin")
    public String admin()
    {
        return "<h1>Welcome ADMIN</h1>";
    }
}
