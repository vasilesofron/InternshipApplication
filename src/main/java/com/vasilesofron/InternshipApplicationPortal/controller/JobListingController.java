package com.vasilesofron.InternshipApplicationPortal.controller;

import com.vasilesofron.InternshipApplicationPortal.model.JobListing;
import com.vasilesofron.InternshipApplicationPortal.repository.JobListingRepository;
import com.vasilesofron.InternshipApplicationPortal.service.JobListingService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/job-listing")
public class JobListingController {

    @Resource
    private JobListingService jobListingService;

    @PostMapping("/create-new-job-listing/{employerId}")
    public JobListing createNewJobListing(@PathVariable Long employerId, @RequestBody JobListing jobListingDetails){
            return jobListingService.createJobListing(employerId, jobListingDetails);
    }



}
