package com.yassine.javaProject.onlineConsultation.repositories;


import com.yassine.javaProject.onlineConsultation.models.Medicine;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MedicineRepository extends CrudRepository<Medicine, Long> {
    List<Medicine> findAll();
}