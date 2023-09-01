package com.yassine.javaProject.onlineConsultation.repositories;

import com.yassine.javaProject.onlineConsultation.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    //FIND All
    Patient findByEmail(String email);

    List<Patient> findAll();
}