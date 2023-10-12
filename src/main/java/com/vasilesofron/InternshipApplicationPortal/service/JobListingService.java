package com.vasilesofron.InternshipApplicationPortal.service;

import com.vasilesofron.InternshipApplicationPortal.model.Employer;
import com.vasilesofron.InternshipApplicationPortal.model.JobListing;
import com.vasilesofron.InternshipApplicationPortal.repository.EmployerRepository;
import com.vasilesofron.InternshipApplicationPortal.repository.JobListingRepository;
import jakarta.annotation.Resource;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobListingService {

    @Resource
    private JobListingRepository jobListingRepository;
    @Resource
    private EmployerRepository employerRepository;

    public JobListing createJobListing(Long employerId, JobListing jobListingDetails){
        Employer employer = employerRepository.findById(employerId)
                .orElseThrow(() -> new EntityNotFoundException("Eployer with ID: " + employerId + " does not exist."));
        JobListing jobListing = new JobListing();
        // We use the getters and setter from the model to create the new jobListing.
        jobListing.setPosition(jobListingDetails.getPosition());
        jobListing.setDescription(jobListingDetails.getDescription());
        jobListing.setLanguage(jobListingDetails.getLanguage());
        jobListing.setEmployer(employer);
        employer.getJobListings().add(jobListing);

        return jobListingRepository.save(jobListing);
    }

    public List<JobListing> getAllJobListings(){
        return jobListingRepository.findAll();
    }

    public void deleteJobListingById(Long jobListingId){
        JobListing jobListing = jobListingRepository.findById(jobListingId)
                .orElseThrow(() -> new EntityNotFoundException("Job Listing with ID: " + jobListingId + " does not exist."));
        jobListingRepository.delete(jobListing);
    }

    public List<JobListing> findAllByEmployer(Long employerId){
        return jobListingRepository.findByEmployerId(employerId);
    }

}
