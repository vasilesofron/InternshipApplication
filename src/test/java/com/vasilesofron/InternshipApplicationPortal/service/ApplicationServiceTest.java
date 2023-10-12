package com.vasilesofron.InternshipApplicationPortal.service;

import com.vasilesofron.InternshipApplicationPortal.model.Applicant;
import com.vasilesofron.InternshipApplicationPortal.model.Application;
import com.vasilesofron.InternshipApplicationPortal.model.JobListing;
import com.vasilesofron.InternshipApplicationPortal.repository.ApplicationRepository;
import com.vasilesofron.InternshipApplicationPortal.repository.ApplicantRepository;
import com.vasilesofron.InternshipApplicationPortal.repository.JobListingRepository;
import com.vasilesofron.InternshipApplicationPortal.repository.EmployerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ApplicationServiceTest {

    @Mock
    private ApplicationRepository applicationRepository;

    @Mock
    private ApplicantRepository applicantRepository;

    @Mock
    private JobListingRepository jobListingRepository;

    @Mock
    private EmployerRepository employerRepository;

    @InjectMocks
    private ApplicationService applicationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    // This test should return a list of all applicants obtained from the mock repository.
    @Test
    void getAllApplicationsTest() {
        List<Application> applications = new ArrayList<>();
        when(applicationRepository.findAll()).thenReturn(applications);

        List<Application> retrievedApplications = applicationService.getAllApplications();

        assertEquals(applications, retrievedApplications);
    }

    // This test should return a list of all applicants for the employer via the employerId.
    @Test
    void getAllJobListingByEmployerTest() {
        Long employerId = 1L;
        List<JobListing> jobListings = new ArrayList<>();
        when(jobListingRepository.findByEmployerId(employerId)).thenReturn(jobListings);

        List<JobListing> retrievedJobListings = applicationService.getAllJobListingByEmployer(employerId);

        assertEquals(jobListings, retrievedJobListings);
    }

    // There should be a lot more tests, but I ran out of time

}
