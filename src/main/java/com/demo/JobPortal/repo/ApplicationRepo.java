package com.demo.JobPortal.repo;

import com.demo.JobPortal.Model.Application;
import com.demo.JobPortal.Model.JobProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepo extends JpaRepository<Application,Long> {


    List<JobProfile> findJobByUserId(long employeeId);

    @Query("Select a.job from application a where a.job.id=:jobid AND a.user.id=:userid")
    List<JobProfile> findByUSerIdAndCompanyId(@Param("jobid") Long userid,@Param("userid") Long jobid);

}
