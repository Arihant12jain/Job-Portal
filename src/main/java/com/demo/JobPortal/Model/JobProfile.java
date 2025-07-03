package com.demo.JobPortal.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@JsonBackReference
private Company company;
private  String location;
private int exp;
private int packag;
private String role;

}
