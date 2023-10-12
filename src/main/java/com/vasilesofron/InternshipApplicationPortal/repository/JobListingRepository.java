package com.vasilesofron.InternshipApplicationPortal.repository;

import com.vasilesofron.InternshipApplicationPortal.model.Employer;
import com.vasilesofron.InternshipApplicationPortal.model.JobListing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobListingRepository extends JpaRepository<JobListing, Long> {

    public JobListing findJobListingById(Long id);
    List<JobListing> findByEmployerId(Long employerId);
    List <JobListing> findJobListingByEmployerId(Long employerId);

}
