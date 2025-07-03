package com.demo.JobPortal.Controller;

import com.demo.JobPortal.Model.User;
import com.demo.JobPortal.Request.Login;
import com.demo.JobPortal.Services.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private Userservice userservice;

    @PostMapping("/signup")
    public String signup(@RequestBody User user){
        System.out.println("Wy");
        User sa= userservice.register(user);
        System.out.println("Hello");
        return "USer Created";
    }
    @PostMapping("/signin")
    public String signin(@RequestBody Login login){
        System.out.println("wrong");
        return String.valueOf(userservice.signin(login));
    }
@GetMapping("/alljobs")
    public List<User> getAllUser(){
        return userservice.findAllUser();
}
}
