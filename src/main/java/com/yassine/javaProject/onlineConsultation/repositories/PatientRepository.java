package com.yassine.javaProject.onlineConsultation.repositories;

import com.yassine.project.onlineConsultation.models.Patient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PatientRepository extends CrudRepository<Patient,Long> {
    //FIND All

    @Override
    List<Patient> findAll();
}
