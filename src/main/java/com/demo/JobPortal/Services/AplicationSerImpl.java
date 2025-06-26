package com.demo.JobPortal.Services;

import com.demo.JobPortal.Model.Application;
import com.demo.JobPortal.Model.JobProfile;
import com.demo.JobPortal.repo.ApplicationRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class AplicationSerImpl implements ApllicationSer{
    @Autowired
    private ApplicationRepo applicationrepo;
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
    public List<JobProfile> getJobsbyUserIdAndCompanyId(Long companyId) {
        return List.of();
    }
}
