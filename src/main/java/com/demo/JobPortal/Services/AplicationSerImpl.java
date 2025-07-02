package com.demo.JobPortal.Services;

import com.demo.JobPortal.Model.Application;
import com.demo.JobPortal.Model.JobProfile;
import com.demo.JobPortal.repo.ApplicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AplicationSerImpl implements ApllicationSer{



    @Autowired
    private ApplicationRepo applicationrepo;

    @Override
    public void create(Application application) {
        Application app=new Application();
        if(application.getJob()!=null){
            app.setJob(application.getJob());
        }
        if(application.getUser()!=null){
            app.setUser(application.getUser());
        }
        Application applica=applicationrepo.save(app);
    }

    @Override
    public List<JobProfile> getJobsbyUserId(long employeeId) {
List<JobProfile> profile=applicationrepo.findJobByUserId(employeeId);
if(profile!=null){
    return profile;
}
      return null;
    }

    @Override
    public List<JobProfile> getJobsbyCompanyId(Long companyId) {
        List<JobProfile> profile=applicationrepo.findJobByUserId(companyId);

        if(profile!=null){
            return profile;
        }
        return null;
    }

    @Override
    public List<JobProfile> getJobsbyUserIdAndCompanyId(Long employeeid, Long companyId) {
        List<JobProfile> jobs=applicationrepo.findByUSerIdAndCompanyId(employeeid,companyId);

        return jobs;
    }
}
