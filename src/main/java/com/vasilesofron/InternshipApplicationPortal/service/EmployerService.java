package com.vasilesofron.InternshipApplicationPortal.service;

import com.vasilesofron.InternshipApplicationPortal.model.Employer;
import com.vasilesofron.InternshipApplicationPortal.repository.EmployerRepository;
import jakarta.annotation.Resource;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerService {

    @Resource
    private EmployerRepository employerRepository;



    public List<Employer> getAllEmployers(){
        return employerRepository.findAll();
    }

    public Employer createEmployer(Employer employer){
        return employerRepository.save(employer);
    }

    public void deleteEmployerById(Long employerId){
        Employer employer = employerRepository.findById(employerId)
                .orElseThrow(() -> new EntityNotFoundException("Employer with ID: " + employerId + " cannot be deleted."));
        employerRepository.delete(employer);
    }


}
