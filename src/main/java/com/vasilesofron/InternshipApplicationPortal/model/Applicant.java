package com.vasilesofron.InternshipApplicationPortal.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import javax.validation.*;

@Entity
@Table(name = "applicants")
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "firstName")
    @NotBlank(message = "First name must not be blank.")
    private String firstName;

    @Column(name = "lastName")
    @NotBlank(message = "Last name must not be blank.")
    private String lastName;

    @Column(name = "phoneNumber")
    @NotBlank(message = "Phone number must not be blank.")
    private String phoneNumber;

    @Column(name = "emailAddress")
    @NotBlank(message = "Email Address must not be blank.")
    @Email(message = "Invalid email address.")
    private String emailAddress;

    @Column(name = "addressLineOne")
    @NotBlank(message = "Address Line One must not be blank.")
    private String addressLineOne;

    @Column(name = "addressLineTwo")
    @NotBlank(message = "Address Line Two must not be blank.")
    private String addressLineTwo;

    @ManyToOne
    @JoinColumn(name = "job_listing_id")
    private JobListing jobListing;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAddressLineOne() {
        return addressLineOne;
    }

    public void setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
    }

    public String getAddressLineTwo() {
        return addressLineTwo;
    }

    public void setAddressLineTwo(String addressLineTwo) {
        this.addressLineTwo = addressLineTwo;
    }

    public Applicant(String firstName, String lastName, String phoneNumber, String emailAddress, String addressLineOne, String addressLineTwo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.addressLineOne = addressLineOne;
        this.addressLineTwo = addressLineTwo;
    }

    public Applicant(){

    }

    // MISSING COUNTRY, STATE, CITY

}
