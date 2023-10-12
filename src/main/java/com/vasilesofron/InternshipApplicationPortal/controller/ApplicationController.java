package com.vasilesofron.InternshipApplicationPortal.controller;

import com.vasilesofron.InternshipApplicationPortal.model.Application;
import com.vasilesofron.InternshipApplicationPortal.service.ApplicantService;
import com.vasilesofron.InternshipApplicationPortal.service.ApplicationService;
import com.vasilesofron.InternshipApplicationPortal.service.EmployerService;
import com.vasilesofron.InternshipApplicationPortal.service.JobListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    @Autowired
    private JobListingService jobListingService;
    @Autowired
    private EmployerService employerService;
    @Autowired
    private ApplicantService applicantService;
    @Autowired
    private ApplicationService applicationService;

    @GetMapping
    public List<Application> getAllApplications(){
        return applicationService.getAllApplications();
    }

    @PostMapping("/{applicantId}/{jobListingId}")
    public Application createJobListing(@PathVariable Long applicantId, @PathVariable Long jobListingId){
        return applicationService.saveApplication(applicantId, jobListingId);
    }

    @GetMapping("/{jobListingId}")
    public ResponseEntity<?> findApplicantsByJobListingId(@PathVariable Long jobListingId){
        return new ResponseEntity<>(applicationService.getAllApplicantByJobListing(jobListingId), HttpStatus.OK);
    }


}
