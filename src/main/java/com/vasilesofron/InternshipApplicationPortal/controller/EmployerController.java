package com.vasilesofron.InternshipApplicationPortal.controller;

import com.vasilesofron.InternshipApplicationPortal.model.Employer;
import com.vasilesofron.InternshipApplicationPortal.model.JobListing;
import com.vasilesofron.InternshipApplicationPortal.service.EmployerService;
import com.vasilesofron.InternshipApplicationPortal.service.JobListingService;
import jakarta.annotation.Resource;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/employers")
public class EmployerController {

    @Autowired
    private EmployerService employerService;
    @Autowired
    private JobListingService jobListingService;

    @GetMapping
    public ResponseEntity<?> getAllEmployers(){
        return new ResponseEntity<>(employerService.getAllEmployers(), HttpStatus.OK);
    }

    @PostMapping("/create-employer")
    public ResponseEntity<?> createEmployer(@RequestBody Employer employer){
        return new ResponseEntity<>(employerService.createEmployer(employer), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-employer/{employerId}")
    public ResponseEntity<?> deleteEmployer(@PathVariable Long employerId){
        try {
            employerService.deleteEmployerById(employerId);
            return ResponseEntity.ok("Employer deleted successfully.");
        } catch (EntityNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No employer found.");
        }
    }
    // Same ExceptionHandler in every controller.
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
