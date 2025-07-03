package com.demo.JobPortal.Controller;

import com.demo.JobPortal.Model.JobProfile;
import com.demo.JobPortal.Model.User;
import com.demo.JobPortal.Request.JobRequest;
import com.demo.JobPortal.Services.ApllicationSer;
import com.demo.JobPortal.Services.JobService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employer")
public class EmployerJobController {

    private final JobService jobservice;
private final ApllicationSer applicationService;
    public EmployerJobController(JobService jobservice, ApllicationSer applicationService){
        this.jobservice=jobservice;
        this.applicationService=applicationService;
    }

@PostMapping("/createJob/{Id}")
    public String create(@RequestBody JobRequest jobreq, @PathVariable("Id") Long companyId){
jobservice.CreateJob(jobreq,companyId);
return "Job Created Successfully";
}


}
