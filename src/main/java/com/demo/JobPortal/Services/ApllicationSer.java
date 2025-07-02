package com.demo.JobPortal.Services;

import com.demo.JobPortal.Model.JobProfile;
import com.demo.JobPortal.Model.Application;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApllicationSer{
    void create(Application application);

    List<JobProfile> getJobsbyUserId(long employeeId);
    List<JobProfile> getJobsbyCompanyId(Long companyId);

@Query("Select a.job from application a where a.job.id=:jobid AND a.user.id=:userid")
    List<JobProfile> getJobsbyUserIdAndCompanyId(Long userid, Long jobId);

}
