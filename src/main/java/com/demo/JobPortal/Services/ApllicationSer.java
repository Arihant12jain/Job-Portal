package com.demo.JobPortal.Services;

import com.demo.JobPortal.Model.JobProfile;

import java.util.List;

public interface ApllicationSer{
    List<JobProfile> getJobsbyUserId(long employeeId);
    List<JobProfile> getJobsbyCompanyId(Long companyId);
    List<JobProfile> getJobsbyUserIdAndCompanyId(Long companyId);

}
