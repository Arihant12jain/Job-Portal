package com.demo.JobPortal.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Job {
    private int exp;
    private String role;
    private String location;
    private int salary;

}
