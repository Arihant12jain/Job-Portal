package com.demo.JobPortal.repo;

import com.demo.JobPortal.Model.JobProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepo extends JpaRepository<JobProfile,Long> {
}
