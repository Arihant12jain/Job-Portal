package com.demo.JobPortal.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Application {

    @ManyToOne
    private User user;
    @ManyToOne
    private JobProfile job;

}
