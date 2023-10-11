package com.vasilesofron.InternshipApplicationPortal.model;


import jakarta.persistence.*;

@Entity
@Table(name = "job_listing")
public class JobListing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "position")
    private String position;

    @Column(name = "employer")
    private String employer;
    @Column(name = "description")
    private String description;
    @Column(name = "language")
    private String language;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public JobListing(String employer, String position, String description, String language) {
        this.employer = employer;
        this.position = position;
        this.description = description;
        this.language = language;
    }

    public JobListing() {

    }
}
