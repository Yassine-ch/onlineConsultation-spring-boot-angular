package com.yassine.javaProject.onlineConsultation.services;

import com.yassine.javaProject.onlineConsultation.models.Consultation;
import com.yassine.javaProject.onlineConsultation.models.Doctor;
import com.yassine.javaProject.onlineConsultation.models.Patient;
import com.yassine.javaProject.onlineConsultation.repositories.ConsultationRepository;

import com.yassine.javaProject.onlineConsultation.repositories.DoctorRepository;
import com.yassine.javaProject.onlineConsultation.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class ConsultationService {
    @Autowired
    ConsultationRepository consultationRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;
    //create a consultation
    public Consultation create (Consultation consultation){
        return  consultationRepository.save(consultation);
    }

    //Read All Consultation
    public List<Consultation> findAllConsultation(){
        return consultationRepository.findAll();
    }
    //Update
    public Consultation update(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
    //Delete Consultation
    public void delete(Long id) {
        Optional<Consultation> optionalShow = consultationRepository.findById(id);
        if(optionalShow.isPresent()) {
            // CascadeType.REMOVE in Show.java will also delete the reviews associated with that show.
            consultationRepository.deleteById(id);
        } else {
            System.out.println("Consultation does not exist");
        }
    }
    //Find By ID
    public Consultation findOneById(Long id) {
        Optional<Consultation> optionalConsultation = consultationRepository.findById(id);

        if(optionalConsultation.isPresent()) {
            return optionalConsultation.get();
        } else {
            return null;
        }
    }


    public Consultation addConsultationWithDoctorID(Consultation cc, Long doctorID, Long patientID) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(doctorID);
        Optional<Patient> patientOptional = patientRepository.findById(patientID);

        if (!doctorOptional.isPresent() || !patientOptional.isPresent()) {
            // Handle the error here. For instance, you can throw an exception.
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor or Patient not found");
        }
        cc.setPatient(patientOptional.get());
        cc.setDoctor(doctorOptional.get());


        return consultationRepository.save(cc);
    }
//    public Consultation createWithDoctorAndPatientIds(Consultation consultation, Long doctorId, Long patientId) {
//        Optional<Doctor> doctorOpt = doctorRepository.findById(doctorId);
//        Optional<Patient> patientOpt = patientRepository.findById(patientId);
//
//        if (doctorOpt.isPresent() && patientOpt.isPresent()) {
//            consultation.setDoctor(doctorOpt.get());
//            consultation.setPatient(patientOpt.get());
//            return consultationRepository.save(consultation);
//        } else {
//            throw new IllegalArgumentException("Doctor or Patient not found by given ID");
//        }
//    }
}
