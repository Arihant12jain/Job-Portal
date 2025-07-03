package com.demo.JobPortal.Services;

import com.demo.JobPortal.Model.Application;
import com.demo.JobPortal.Model.JobProfile;
import com.demo.JobPortal.Model.User;
import com.demo.JobPortal.Request.Applicationrequest;
import com.demo.JobPortal.repo.ApplicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AplicationSerImpl implements ApllicationSer{



    private ApplicationRepo applicationrepo;
private final JobService jobservice;
private final Userservice userservice;

public AplicationSerImpl(JobService jobservice,Userservice userservice,ApplicationRepo applicationrepo){
    this.jobservice=jobservice;
    this.userservice=userservice;
    this.applicationrepo=applicationrepo;
}
    @Override
    public void create(Applicationrequest application) {
        Application app=new Application();
        System.out.println(application.getJobid()+" "+application.getUserid());
        JobProfile job=jobservice.findById(application.getJobid());
        User user=userservice.findById(application.getUserid());
        app.setUser(user);
        app.setJob(job);
        applicationrepo.save(app);

    }
    @Override
    public void delete(long id) {
applicationrepo.deleteById(id);
    }

    @Override
    public List<JobProfile> getJobsbyUserId(long employeeId) {
List<JobProfile> profile=applicationrepo.findJobByUserId(employeeId);
if(profile!=null){
    return profile;
}
      return null;
    }

    @Override
    public List<JobProfile> getJobsbyCompanyId(Long companyId) {
        List<JobProfile> profile=applicationrepo.findJobByUserId(companyId);

        if(profile!=null){
            return profile;
        }
        return null;
    }

    @Override
    public List<User> findUserByJobId(Long JobId) {
        List<User> userlist=applicationrepo.findUserByJobId(JobId);
        return userlist;
    }

    @Override
    public List<JobProfile> getJobsbyUserIdAndCompanyId(Long employeeid, Long companyId) {
        List<JobProfile> jobs=applicationrepo.findByUserIdAndJobId(employeeid,companyId);
        return jobs;
    }

    @Override
    public void AcceptApplication(long id) {
        Optional<Application> application=applicationrepo.findById(id);
        if(application.isPresent()){
            application.get().setStatus(true);
        }
        applicationrepo.save(application.get());
    }

}
