package com.demo.JobPortal.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Company{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String email;
    @Embedded
    private Address address;
@OneToMany
    List<JobProfile> jobs;
@OneToOne
    private User user;
}
