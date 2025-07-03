package com.demo.JobPortal.Controller;

import com.demo.JobPortal.Model.Company;
import com.demo.JobPortal.Model.User;
import com.demo.JobPortal.Request.CompanyRequest;
import com.demo.JobPortal.Services.ApllicationSer;
import com.demo.JobPortal.Services.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employer")
public class CompanyController {
    private final CompanyService companyservice;
private final ApllicationSer appservice;
    public CompanyController(CompanyService companyservice,ApllicationSer applicationservice){
        this.companyservice=companyservice;
        this.appservice=applicationservice;
    }
    @PostMapping("/create")
    public String create(@RequestBody CompanyRequest companyrequest){
        companyservice.CreateCompany(companyrequest);
        return "Company Created";
    }
    @GetMapping("/getallcompany")
    public List<Company> getALlCompany(){
        List<Company>company=companyservice.findAll();
        return company;
    }
 @GetMapping("/getapplieduser/{id}")
    public List<User>getAppliedUser(@PathVariable("id") Long id){
List<User>ss=appservice.findUserByJobId(id);
return ss;
 }
}
