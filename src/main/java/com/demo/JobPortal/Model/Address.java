package com.demo.JobPortal.Model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Address {
    private String city;
    private String state;
    private String locality;
    private int housenum;
}
