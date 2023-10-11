package com.vasilesofron.InternshipApplicationPortal.service;

import com.vasilesofron.InternshipApplicationPortal.repository.ApplicationRepository;
import com.vasilesofron.InternshipApplicationPortal.repository.ApplicantRepository;
import com.vasilesofron.InternshipApplicationPortal.repository.JobListingRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

    @Resource
    private ApplicationRepository applicationRepository;

    @Resource
    private ApplicantRepository applicantRepository;

    @Resource
    private JobListingRepository jobListingRepository;



}
