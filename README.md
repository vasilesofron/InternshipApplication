InternshipApplication

**This project has been created using the SpringBoot 3.1.4 and Java 17.**

**This project uses PostgreSQL as the database. Please make sure to CREATE DATABASE before, the tables and rows are created automatically.**

**Please check the application.propertiese file and make the required changes.**

This project allows the creation of applicants, job listings, employers and the application of different applicants to a job listing created by an employer.

The project has been divided in different layers:
Model Layer | Controller Layer | Service Layer | Repositories

This is possible by accesing different endpoints via a GET/POST/DELETE request.

The project has the following endpoints:

/employers [GET]
/employers/create-employer [POST]
/employers/delete-employer/{employerId} [DELETE]
/job-listing [GET]
/job-listing/create-new-job-listing/{employerId} [POST]
/job-listing/delete-job-listing/{jobListingId} [DELETE]
/job-listing/get-job-listing-by-employer-id/{employerId} [GET]
/applications [GET]
/applications/{applicantId}/{jobListingId} [POST]
/applications/{jobListingId} [GET]
/applicants [GET]
/applicants/create-applicant [POST]
/applicants/{employerId} [GET]

In this README I have also added the ERD(entity relationship diagram).

More things need to be added, soon!

Thank you! 

![Sofron_Vasile_ERD_ddroidd](https://github.com/vasilesofron/ddroid_InternshipApplicationPortal/assets/73953076/bb7ccad6-ed37-4340-a184-754f2b9aa360)
