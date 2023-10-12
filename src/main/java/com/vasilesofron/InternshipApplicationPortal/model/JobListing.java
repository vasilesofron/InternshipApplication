package com.vasilesofron.InternshipApplicationPortal.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "job_listing")
public class JobListing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "position")
    @NotBlank(message = "Job position must not be blank.")
    private String position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employer_id")
    @JsonIgnore
    private Employer employer;
    @Column(name = "description")
    @NotBlank(message = "Job description must not be blank.")
    private String description;
    @Column(name = "language")
    @NotBlank(message = "Job language must not be blank.")
    private String language;

    // More fields can be created using the same logic found in the lines above.

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

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public JobListing(String position, Employer employer, String description, String language) {
        this.position = position;
        this.employer = employer;
        this.description = description;
        this.language = language;
    }

    public JobListing() {

    }
}
