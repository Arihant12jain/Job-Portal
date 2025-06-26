package com.demo.JobPortal.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Application {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;

    @ManyToOne
    private User user;
    @ManyToOne
    private JobProfile job;

}
