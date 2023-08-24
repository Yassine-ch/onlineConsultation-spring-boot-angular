package com.yassine.javaProject.onlineConsultation.repositories;

import com.yassine.project.onlineConsultation.models.Doctor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends CrudRepository <Doctor,Long> {

//    //FIND All
//
    @Override
    List<Doctor> findAll();
    //FIND BY ID
//
//    @Override
//    Optional findById(Object o);
}
