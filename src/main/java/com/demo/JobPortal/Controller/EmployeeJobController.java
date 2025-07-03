package com.demo.JobPortal.Controller;

import com.demo.JobPortal.Model.JobProfile;
import com.demo.JobPortal.Services.ApllicationSer;
import com.demo.JobPortal.Services.JobService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeJobController {

    private final JobService jobservice;
    private final ApllicationSer applicationService;

    public EmployeeJobController(JobService jobservice, ApllicationSer applicationService){
        this.jobservice=jobservice;
        this.applicationService=applicationService;
    }
 @GetMapping("/getJobofUser/{Id}")
    public List<JobProfile> getJobsByUserId(@PathVariable("Id") long id){
        List<JobProfile>jobsofUser=applicationService.getJobsbyUserId(id);
        return jobsofUser;
    }
    @GetMapping("/alljobs")
    public List<JobProfile> getAllJobs(){
        return jobservice.getAllJobs();
    }
    @GetMapping("/getjobByCompanyId/{Id}")
    public List<JobProfile> getJobByCompanyId(@PathVariable("Id") long Id){
        List<JobProfile> jobs=jobservice.getJobByCmpnyId(Id);
        return jobs;
    }

}
