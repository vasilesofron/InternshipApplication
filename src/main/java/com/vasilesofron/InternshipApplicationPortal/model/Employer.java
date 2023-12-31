package com.vasilesofron.InternshipApplicationPortal.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employer")
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "Employer name must not be blank.")
    private String name;

    // jobListings are a ... List ofc :D
    @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<JobListing> jobListings = new ArrayList<>();

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

    public List<JobListing> getJobListings() {
        return jobListings;
    }



    public void setJobListings(List<JobListing> jobListing) {
        this.jobListings = jobListing;
    }

    public Employer(String name) {
        this.name = name;
    }

    public Employer(){

    }
}
