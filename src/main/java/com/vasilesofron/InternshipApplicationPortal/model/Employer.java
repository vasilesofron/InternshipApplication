package com.vasilesofron.InternshipApplicationPortal.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "employer")
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany
    private List<JobListing> jobListing;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<JobListing> getJobListing() {
        return jobListing;
    }

    public void setJobListing(List<JobListing> jobListing) {
        this.jobListing = jobListing;
    }

    public Employer(String name) {
        this.name = name;
    }

    public Employer(){

    }
}
