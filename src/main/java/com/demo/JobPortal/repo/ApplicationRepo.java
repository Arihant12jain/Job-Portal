package com.demo.JobPortal.repo;

import com.demo.JobPortal.Model.Application;
import com.demo.JobPortal.Model.JobProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepo extends JpaRepository<Application,Long> {


    List<JobProfile> findJobByUserId(long employeeId);
}
