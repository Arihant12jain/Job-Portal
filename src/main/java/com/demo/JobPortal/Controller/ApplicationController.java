package com.demo.JobPortal.Controller;

import com.demo.JobPortal.Model.Application;
import com.demo.JobPortal.Request.Applicationrequest;
import com.demo.JobPortal.Services.ApllicationSer;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApplicationController {
    private final ApllicationSer appservice;

    public ApplicationController(ApllicationSer appservice){
        this.appservice=appservice;
    }

    @PostMapping("/create")
    public String create(@RequestBody Applicationrequest apprequest){
        appservice.create(apprequest);
return "Application created";
    }

   @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id){
        appservice.delete(id);
        return "Application deleted";
   }
   @PutMapping("/accept/{id}")
    public String AcceptedByCompany(@PathVariable("id") long id){
       appservice.AcceptApplication(id);
        return "Application Accepted";
   }
}
