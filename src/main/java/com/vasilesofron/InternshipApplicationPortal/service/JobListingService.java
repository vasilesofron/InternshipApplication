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

    /*public JobListing createJobListing(Long employerId, JobListing jobListing){
        Employer employer = employerRepository.findEmployerById(employerId);
        if(employer != null){
            jobListingRepository.save(jobListing);
            List<JobListing> newJobListing = employer.getJobListing();
            newJobListing.add(jobListing);
            employer.setJobListing(newJobListing);
            return jobListing;
        }
        return null;
    }
     */


    public JobListing createJobListing(Long employerId, JobListing jobListingDetails){
        Employer employer = employerRepository.findById(employerId)
                .orElseThrow(() -> new EntityNotFoundException("Employer with the ID: " + employerId + " does not exist."));

        JobListing jobListing = new JobListing();
        jobListing.setEmployer(jobListingDetails.getEmployer());
        jobListing.setPosition(jobListingDetails.getPosition());
        jobListing.setDescription(jobListingDetails.getDescription());
        jobListing.setLanguage(jobListingDetails.getLanguage());

        return jobListingRepository.save(jobListing);

    }

}
