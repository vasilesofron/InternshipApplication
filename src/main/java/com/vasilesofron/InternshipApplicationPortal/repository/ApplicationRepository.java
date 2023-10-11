package com.vasilesofron.InternshipApplicationPortal.repository;

import com.vasilesofron.InternshipApplicationPortal.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
