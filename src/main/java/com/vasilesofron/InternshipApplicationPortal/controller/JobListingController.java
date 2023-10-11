package com.vasilesofron.InternshipApplicationPortal.controller;

import com.vasilesofron.InternshipApplicationPortal.model.JobListing;
import com.vasilesofron.InternshipApplicationPortal.repository.JobListingRepository;
import com.vasilesofron.InternshipApplicationPortal.service.JobListingService;
import jakarta.annotation.Resource;
import jakarta.persistence.EntityNotFoundException;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/job-listing")
public class JobListingController {

    @Resource
    private JobListingService jobListingService;

    @GetMapping
    public ResponseEntity<?> getAllJobListings(){
        return new ResponseEntity<>(jobListingService.getAllJobListings(), HttpStatus.OK);
    }

    @PostMapping("/create-new-job-listing/{employerId}")
    public JobListing createNewJobListing(@PathVariable Long employerId, @RequestBody JobListing jobListingDetails){
            return jobListingService.createJobListing(employerId, jobListingDetails);
    }

    @DeleteMapping("/delete-job-listing/{jobListingId}")
    public ResponseEntity<?> deleteJobListing(@PathVariable Long jobListingId){
        try {
            jobListingService.deleteJobListingById(jobListingId);
            return ResponseEntity.ok("Job Listing deleted.");
        } catch (EntityNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Job Listing Found.");
        }
    }




}
