package com.demo.JobPortal.Services;

import com.demo.JobPortal.Model.User;
import com.demo.JobPortal.Request.Login;

public interface Userservice {

    public User register(User user);
    public String signin(Login login);
}
