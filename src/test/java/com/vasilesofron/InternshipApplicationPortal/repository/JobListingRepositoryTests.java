package com.vasilesofron.InternshipApplicationPortal.repository;

import com.vasilesofron.InternshipApplicationPortal.model.JobListing;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class JobListingRepositoryTests {

    @Autowired
    private JobListingRepository jobListingRepository;

    @Test
    public void jobListingRepositoryShouldSaveJobListingAndReturnSavedJobListing(){
        JobListing jobListing = new JobListing();
        jobListing.setLanguage("Romanian");
        jobListing.setDescription("New Developer Position.");
        jobListing.setPosition("Java Developer");

            }


}
