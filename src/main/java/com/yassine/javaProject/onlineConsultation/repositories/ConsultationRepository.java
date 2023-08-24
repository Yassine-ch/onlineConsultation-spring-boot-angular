package com.yassine.javaProject.onlineConsultation.repositories;

import com.yassine.project.onlineConsultation.models.Consultation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ConsultationRepository extends CrudRepository<Consultation, Long> {
//   //FIND All

   @Override
   List<Consultation> findAll();
//    //FIND BY ID
//

}
