package com.vasilesofron.InternshipApplicationPortal.controller;

import com.vasilesofron.InternshipApplicationPortal.model.Applicant;
import com.vasilesofron.InternshipApplicationPortal.service.ApplicantService;
import com.vasilesofron.InternshipApplicationPortal.service.ApplicationService;
import com.vasilesofron.InternshipApplicationPortal.service.EmployerService;
import com.vasilesofron.InternshipApplicationPortal.service.JobListingService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applicants")
public class ApplicantController {

    @Autowired
    private JobListingService jobListingService;
    @Autowired
    private EmployerService employerService;
    @Autowired
    private ApplicantService applicantService;
    @Autowired
    private ApplicationService applicationService;

    @GetMapping
    public List<Applicant> getAllApplicants(){
        return applicantService.findAllApplicants();
    }

    @PostMapping("/create-applicant")
    public Applicant createApplicant(@RequestBody Applicant applicant){
        return applicantService.saveApplicant(applicant);
    }

    @GetMapping("/{employerId}")
    public ResponseEntity<?> findApplicantsByEmployer(@PathVariable Long employerId){
        return new ResponseEntity<>(applicantService.findAllApplicantsByEmployer(employerId), HttpStatus.OK);
    }

}
