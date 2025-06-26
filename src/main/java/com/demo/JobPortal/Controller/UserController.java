package com.demo.JobPortal.Controller;

import com.demo.JobPortal.Model.User;
import com.demo.JobPortal.Request.Login;
import com.demo.JobPortal.Services.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private Userservice userservice;

    @PostMapping("/signup")
    public User signup(@RequestBody User user){
        System.out.println("Wy");
        User sa= userservice.register(user);
        System.out.println(sa.getEmail());
        return sa;
    }
    @PostMapping("/signin")
    public String signin(@RequestBody Login login){
        System.out.println("wrong");
        return String.valueOf(userservice.signin(login));
    }
}
