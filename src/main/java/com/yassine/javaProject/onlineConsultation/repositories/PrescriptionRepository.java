package com.yassine.javaProject.onlineConsultation.repositories;

import com.yassine.javaProject.onlineConsultation.models.Prescription;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PrescriptionRepository extends CrudRepository<Prescription, Long> {
    List<Prescription> findAll();
}