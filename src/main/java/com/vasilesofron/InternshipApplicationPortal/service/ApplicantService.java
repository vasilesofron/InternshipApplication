package com.vasilesofron.InternshipApplicationPortal.service;

import com.vasilesofron.InternshipApplicationPortal.model.Applicant;
import com.vasilesofron.InternshipApplicationPortal.model.Application;
import com.vasilesofron.InternshipApplicationPortal.model.Employer;
import com.vasilesofron.InternshipApplicationPortal.model.JobListing;
import com.vasilesofron.InternshipApplicationPortal.repository.ApplicantRepository;
import com.vasilesofron.InternshipApplicationPortal.repository.ApplicationRepository;
import com.vasilesofron.InternshipApplicationPortal.repository.EmployerRepository;
import com.vasilesofron.InternshipApplicationPortal.repository.JobListingRepository;
import jakarta.annotation.Resource;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicantService {

    @Resource
    private ApplicantRepository applicantRepository;
    @Resource
    private ApplicationRepository applicationRepository;
    @Resource
    private EmployerRepository employerRepository;
    @Resource
    private JobListingRepository jobListingRepository;


    public Applicant saveApplicant(Applicant applicant) {
        return applicantRepository.save(applicant);
    }

    public List<Applicant> findAllApplicants() {
        return applicantRepository.findAll();
    }

    public List<Applicant> findAllApplicantsByEmployer(Long employerId) {
        //Employer employer = employerRepository.findById(employerId)
                //.orElseThrow(() -> new EntityNotFoundException("There is no employer with ID: " + employerId));
        List<JobListing> jobs = jobListingRepository.findJobListingByEmployerId(employerId);
        List<Application> applications = applicationRepository.findAll();
        List<Applicant> applicants = new ArrayList<>();

        for (JobListing job : jobs) {
            for (Application application : applications) {
                if (application.getJobListing() == job) {
                    applicants.add(application.getApplicant());
                }
            }
        }
        return applicants;
    }
}