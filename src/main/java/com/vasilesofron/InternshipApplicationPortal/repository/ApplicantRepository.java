package com.vasilesofron.InternshipApplicationPortal.repository;

import com.vasilesofron.InternshipApplicationPortal.model.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
}
