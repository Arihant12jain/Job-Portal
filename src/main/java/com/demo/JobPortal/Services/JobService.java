package com.demo.JobPortal.Services;

import com.demo.JobPortal.Model.JobProfile;
import com.demo.JobPortal.Request.JobRequest;

import java.util.List;

public interface JobService {
    public String CreateJob(JobRequest jobRequest);
    public List<JobProfile> getAllJobs();
    public List<JobProfile> getJobByCmpnyId(long companyid);
}
