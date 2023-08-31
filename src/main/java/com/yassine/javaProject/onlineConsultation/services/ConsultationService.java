package com.yassine.javaProject.onlineConsultation.services;

import com.yassine.javaProject.onlineConsultation.models.Consultation;
import com.yassine.javaProject.onlineConsultation.models.Doctor;
import com.yassine.javaProject.onlineConsultation.models.Patient;
import com.yassine.javaProject.onlineConsultation.repositories.ConsultationRepository;
import com.yassine.javaProject.onlineConsultation.repositories.DoctorRepository;
import com.yassine.javaProject.onlineConsultation.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ConsultationService {

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    // Create a consultation directly
    public Consultation create(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    // Read All Consultation
    public List<Consultation> findAllConsultation() {
        return consultationRepository.findAll();
    }

    // Update a consultation
    public Consultation update(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    // Delete Consultation by ID
    public void delete(Long id) {
        if (consultationRepository.existsById(id)) {
            consultationRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Consultation not found by given ID");
        }
    }

    // Find Consultation By ID
    public Consultation findOneById(Long id) {
        return consultationRepository.findById(id).orElse(null);
    }

    // Find Consultations By Patient ID
    public List<Consultation> findConsultationsByPatientId(Long patientId) {
        return consultationRepository.findByPatientId(patientId);
    }

    // Add a consultation with a specified doctor's ID
    public Consultation addConsultationWithDoctorID(Consultation cc, Long doctorID,Long patientID) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(doctorID);
        Optional<Patient> patientOptional = patientRepository.findById(patientID);

        if (doctorOptional.isPresent()) {
            cc.setDoctor(doctorOptional.get());
            cc.setPatient(patientOptional.get());
            return consultationRepository.save(cc);
        } else {
            throw new IllegalArgumentException("Doctor not found by given ID");
        }
    }

    // Add a consultation with specified details
    public Consultation addConsultation(Doctor doctor, Patient patient, String status, Date startTime, Date endTime, String concerns, String diseases) {
        Consultation consultation = new Consultation();
        consultation.setDoctor(doctor);
        consultation.setPatient(patient);
        consultation.setStatus(status);
        consultation.setStartTime(startTime);
        consultation.setEndTime(endTime);
        consultation.setConcerns(concerns);
        consultation.setDiseases(diseases);
        return consultationRepository.save(consultation);
    }
}
