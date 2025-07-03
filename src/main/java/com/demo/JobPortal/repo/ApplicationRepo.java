package com.demo.JobPortal.repo;

import com.demo.JobPortal.Model.Application;
import com.demo.JobPortal.Model.JobProfile;
import com.demo.JobPortal.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepo extends JpaRepository<Application,Long> {
@Query("Select a.job from Application a where a.user.id=:userid")
    List<JobProfile> findJobByUserId(@Param("userid") long userid);
    @Query("Select a.job from Application a where a.job.id=:jobid AND a.user.id=:userid")
    List<JobProfile> findByUserIdAndJobId(@Param("jobid") Long userid,@Param("userid") Long jobid);
@Query("Select a.user from Application a where a.job.id=:jobid")
    List<User> findUserByJobId(@Param("jobid")Long jobId);
}
