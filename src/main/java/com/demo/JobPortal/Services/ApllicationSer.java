package com.demo.JobPortal.Services;

import com.demo.JobPortal.Model.Application;
import com.demo.JobPortal.Model.JobProfile;
import com.demo.JobPortal.Model.User;
import com.demo.JobPortal.Request.Applicationrequest;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApllicationSer{
    void create(Applicationrequest application);
void delete(long id);
    List<JobProfile> getJobsbyUserId(long employeeId);
    List<JobProfile> getJobsbyCompanyId(Long companyId);
    List<User> findUserByJobId(Long JobId);

@Query("Select a.job from application a where a.job.id=:jobid AND a.user.id=:userid")
    List<JobProfile> getJobsbyUserIdAndCompanyId(Long userid, Long jobId);
void AcceptApplication(long id);
}
