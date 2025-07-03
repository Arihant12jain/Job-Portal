package com.demo.JobPortal.Services;

import com.demo.JobPortal.Model.Company;
import com.demo.JobPortal.Model.JobProfile;
import com.demo.JobPortal.Model.User;
import com.demo.JobPortal.Request.CompanyRequest;
import com.demo.JobPortal.repo.Companyrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    private Companyrepo componyrepo;

    @Override
    public void CreateCompany(CompanyRequest company) {
        Company company1=new Company();
        company1.setName(company.getName());
        company1.setEmail(company.getEmail());
        company1.setAddress(company.getAddress());
        Company saved=componyrepo.save(company1);
        System.out.println(saved.getEmail()+company1.getEmail());
    }

    @Override
    public List<JobProfile> findAllByCompanyId(Long CompanyId) {
        List<JobProfile> jobs=componyrepo.findJobsById(CompanyId);
        if(jobs==null){
            return Collections.emptyList();
        }
        return jobs;
    }

    @Override
    public List<Company> findAll() {
        return componyrepo.findAll();
    }

    @Override
    public Company findByCompanyId(long cmpnyId){
        Optional<Company> cmpny=componyrepo.findById(cmpnyId);
     if(cmpny.isPresent()){
         return cmpny.get();
     }
     return null;
    }



}
