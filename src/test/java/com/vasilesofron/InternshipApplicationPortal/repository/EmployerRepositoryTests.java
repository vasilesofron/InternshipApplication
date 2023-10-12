package com.vasilesofron.InternshipApplicationPortal.repository;

import com.vasilesofron.InternshipApplicationPortal.model.Employer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class EmployerRepositoryTests {

    @Autowired
    private EmployerRepository employerRepository;

    @Test
    public void employerRepositoryShouldSaveAllAndReturnSavedEmployer(){

        Employer employer = new Employer();
        employer.setName("ddroid");

        employerRepository.save(employer);

        Optional<Employer> savedEmployer = employerRepository.findById(employer.getId());




    }

}
