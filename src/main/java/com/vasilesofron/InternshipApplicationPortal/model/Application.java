package com.vasilesofron.InternshipApplicationPortal.model;

import jakarta.persistence.*;

@Entity
@Table(name = "application")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "applicant_id", referencedColumnName = "id")
    Applicant applicant;

    @ManyToOne
    @JoinColumn(name = "joblisting_id", referencedColumnName = "id")
    JobListing jobListing;

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public JobListing getJobListing() {
        return jobListing;
    }

    public void setJobListing(JobListing jobListing) {
        this.jobListing = jobListing;
    }

    public Application(Applicant applicant, JobListing jobListing) {
        this.applicant = applicant;
        this.jobListing = jobListing;
    }

    public Application() {
    }
}

