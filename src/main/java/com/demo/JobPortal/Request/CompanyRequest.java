package com.demo.JobPortal.Request;

import com.demo.JobPortal.Model.Address;
import jakarta.persistence.Embedded;
import lombok.Data;

@Data
public class CompanyRequest {

    private String name;
    private String email;
    @Embedded
    private Address address;
}
