package com.demo.JobPortal.repo;

import com.demo.JobPortal.Model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Companyrepo extends JpaRepository<Company,Long> {
}
