package com.demo.JobPortal.Services;

import com.demo.JobPortal.Model.JobProfile;
import com.demo.JobPortal.Request.JobRequest;
import org.springframework.stereotype.Service;

import java.util.List;


public interface JobService {
    public String CreateJob(JobRequest jobRequest,Long companyId);
    public List<JobProfile> getAllJobs();
    public List<JobProfile> getJobByCmpnyId(long companyid);

   public JobProfile findById(Long id);
}
