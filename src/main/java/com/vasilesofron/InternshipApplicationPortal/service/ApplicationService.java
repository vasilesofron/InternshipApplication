package com.vasilesofron.InternshipApplicationPortal.service;

import com.vasilesofron.InternshipApplicationPortal.model.Applicant;
import com.vasilesofron.InternshipApplicationPortal.model.Application;
import com.vasilesofron.InternshipApplicationPortal.model.Employer;
import com.vasilesofron.InternshipApplicationPortal.model.JobListing;
import com.vasilesofron.InternshipApplicationPortal.repository.ApplicationRepository;
import com.vasilesofron.InternshipApplicationPortal.repository.ApplicantRepository;
import com.vasilesofron.InternshipApplicationPortal.repository.EmployerRepository;
import com.vasilesofron.InternshipApplicationPortal.repository.JobListingRepository;
import jakarta.annotation.Resource;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ApplicationService {

    @Resource
    private ApplicationRepository applicationRepository;

    @Resource
    private ApplicantRepository applicantRepository;

    @Resource
    private JobListingRepository jobListingRepository;

    @Resource
    private EmployerRepository employerRepository;

    public Application saveApplication(Long applicantId, Long jobListingId) {
        Applicant applicant = applicantRepository.findById(applicantId).orElseThrow(() -> new EntityNotFoundException("There is not applicant with ID: " + applicantId));
        JobListing jobListing = jobListingRepository.findById(jobListingId)
                .orElseThrow(() -> new EntityNotFoundException("There is no JobListing with the ID: "));
        Application application = new Application(applicant, jobListing);
        return applicationRepository.save(application);
    }

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    public List<JobListing> getAllJobListingByEmployer(Long employerId) {
        //Employer employer = employerRepository.findById(employerId)
               // .orElseThrow(() -> new EntityNotFoundException("There is no employer with ID: " + employerId));
        return jobListingRepository.findByEmployerId(employerId);
    }

    public List<Applicant> getAllApplicantByJobListing(Long jobListingId) {
        List<Applicant> applicants = new ArrayList<>();
        List<Application> applications = applicationRepository.findAll();
        for (Application application : applications) {
            if (Objects.equals(application.getJobListing().getId(), jobListingId)) {
                applicants.add(application.getApplicant());
            }
        }
        return applicants;
    }

}
