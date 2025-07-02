package com.demo.JobPortal.Services;

import com.demo.JobPortal.Model.Company;
import com.demo.JobPortal.Model.JobProfile;
import com.demo.JobPortal.Request.CompanyRequest;

import java.util.List;

public interface CompanyService {


    void CreateCompany(CompanyRequest company);

    List<JobProfile> findAllByCompanyId(Long CompanyId);


}
