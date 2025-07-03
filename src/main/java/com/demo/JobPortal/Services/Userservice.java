package com.demo.JobPortal.Services;

import com.demo.JobPortal.Model.User;
import com.demo.JobPortal.Request.Login;

import java.util.List;

public interface Userservice {

    public User register(User user);
    public String signin(Login login);
    public User findById(long id);
    public List<User> findAllUser();
}
