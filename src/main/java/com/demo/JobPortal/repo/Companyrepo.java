package com.demo.JobPortal.repo;

import com.demo.JobPortal.Model.Company;
import com.demo.JobPortal.Model.JobProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Companyrepo extends JpaRepository<Company,Long> {
    List<JobProfile> findJobsById(Long companyId);

}
