package com.demo.JobPortal.Services;

import com.demo.JobPortal.Model.Company;
import com.demo.JobPortal.Model.JobProfile;
import com.demo.JobPortal.Request.JobRequest;
import com.demo.JobPortal.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService{



    private final CompanyService cmpnyservice;

private final JobRepo jobrepo;


public JobServiceImpl(CompanyService cmpnyservice,JobRepo jobrepo){
    this.cmpnyservice=cmpnyservice;

    this.jobrepo=jobrepo;
}
    @Override
    public String CreateJob(JobRequest job,Long compnyId) {
        JobProfile create=new JobProfile();
        Company cmpny=cmpnyservice.findByCompanyId(compnyId);
        create.setRole(job.getRole());
        create.setExp(job.getExp());
        create.setLocation(job.getLocation());
        create.setPackag(job.getSalary());
        create.setCompany(cmpny);
        cmpny.getJobs().add(create);
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

    @Override
    public JobProfile findById(Long id){
        Optional<JobProfile> job=jobrepo.findById(id);
        return job.get();
    }

}
