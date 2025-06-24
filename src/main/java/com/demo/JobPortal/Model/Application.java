package com.demo.JobPortal.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Application {

    @ManyToOne
    private User user;
    @ManyToOne
    private JobProfile job;

}
