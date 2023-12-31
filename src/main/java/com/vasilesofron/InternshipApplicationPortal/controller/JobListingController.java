package com.vasilesofron.InternshipApplicationPortal.controller;

import com.vasilesofron.InternshipApplicationPortal.model.JobListing;
import com.vasilesofron.InternshipApplicationPortal.repository.JobListingRepository;
import com.vasilesofron.InternshipApplicationPortal.service.JobListingService;
import jakarta.annotation.Resource;
import jakarta.persistence.EntityNotFoundException;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/job-listing")
public class JobListingController {

    @Autowired
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
        // Should use Exception Handler / Custom exception classes
        try {
            jobListingService.deleteJobListingById(jobListingId);
            return ResponseEntity.ok("Job Listing deleted.");
        } catch (EntityNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Job Listing Found.");
        }
    }

    @GetMapping("/get-job-listing-by-employer-id/{employerId}")
    public ResponseEntity<?> getJobListingByEmployer(@PathVariable Long employerId){
        return new ResponseEntity<>(jobListingService.findAllByEmployer(employerId), HttpStatus.OK);
    }

    // Same exceptions that we find in each controller.
    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleBadRequest(HttpClientErrorException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleNotFoundException(NoSuchElementException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }


}
