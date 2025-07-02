package com.demo.JobPortal.Request;


import com.demo.JobPortal.Model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Login {
    private String email;
    private int password;
    private Role role;
}
