package com.yassine.javaProject.onlineConsultation.repositories;

import com.yassine.javaProject.onlineConsultation.models.Consultation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ConsultationRepository extends CrudRepository<Consultation, Long> {
//   //FIND All

   List<Consultation> findAll();
   //FIND ALL BY ID
//FIND consulation by patient iD
   List<Consultation> findByPatientId(Long patientId);
//    //FIND BY ID

Optional<Consultation> findById(Long aLong);

}
