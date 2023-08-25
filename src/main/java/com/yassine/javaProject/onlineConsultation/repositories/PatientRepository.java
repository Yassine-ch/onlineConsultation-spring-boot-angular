package com.yassine.javaProject.onlineConsultation.repositories;

import com.yassine.javaProject.onlineConsultation.models.Patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByEmail(String email);
}