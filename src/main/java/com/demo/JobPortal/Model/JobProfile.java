package com.demo.JobPortal.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JobProfile {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
@ManyToOne
private Company company;
private  String location;
private String exp;

private int packag;

private String role;



}
