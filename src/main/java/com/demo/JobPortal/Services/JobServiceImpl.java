package com.demo.JobPortal.Services;

import com.demo.JobPortal.Model.Company;
import com.demo.JobPortal.Model.JobProfile;
import com.demo.JobPortal.Request.JobRequest;
import com.demo.JobPortal.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class JobServiceImpl implements JobService{
@Autowired
    private  CompanyService cmpnyservice;
@Autowired
private JobRepo jobrepo;
    @Override
    public String CreateJob(JobRequest job,Long compnyId) {
        JobProfile create=new JobProfile();
        Company cmpny=cmpnyservice.findByCompanyId(compnyId);
        create.setRole(job.getRole());
        create.setExp(job.getExp());
        create.setPackag(job.getSalary());
        create.setCompany(cmpny);
        jobrepo.save(create);
        return "Job Created SuccessFully";
    }

    @Override
    public List<JobProfile> getAllJobs() {
        return jobrepo.findAll();
    }

    @Override
    public List<JobProfile> getJobByCmpnyId(long companyid) {
        return jobrepo.findByCompanyId(companyid);
    }
}
