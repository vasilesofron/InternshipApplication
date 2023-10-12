package com.vasilesofron.InternshipApplicationPortal.model;

import jakarta.persistence.*;

@Entity
@Table(name = "application")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne // This allows the applicant to apply multiple times at the same job.
    // Not necessarily wrong, but preferably there should be only one application per candidate for the same position.
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

