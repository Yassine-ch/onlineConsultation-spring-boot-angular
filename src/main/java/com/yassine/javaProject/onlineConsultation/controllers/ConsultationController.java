package com.yassine.javaProject.onlineConsultation.controllers;

import com.yassine.javaProject.onlineConsultation.models.Consultation;
import com.yassine.javaProject.onlineConsultation.services.ConsultationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;

    // Create One Consultation
//    @PostMapping(value = "/consultations")
//    public ResponseEntity<Consultation> createConsultation(@RequestBody Consultation consultation) {
//        Consultation consultationCreated = consultationService.create(consultation);
//        return new ResponseEntity<>(consultationCreated, HttpStatus.CREATED);
//    }
    ///*/*/*/*/* CONSULATATION WITH DOCTOR ID

    @PostMapping("/consultation/create/{patientId}/{doctorId}")
    public Consultation addConsultationWithDoctorId(
            @RequestBody Consultation cc,
            @PathVariable("doctorId") Long doctorID,
            @PathVariable("patientId") Long patientID)
    {
        return consultationService.addConsultationWithDoctorID(cc, doctorID, patientID);
    }
    // Get All Consultations
    @GetMapping("/consultations")
    public ResponseEntity<List<Consultation>> getAllConsultations() {
        List<Consultation> allConsultations = consultationService.findAllConsultation();
        return new ResponseEntity<>(allConsultations, HttpStatus.OK);
    }

    // Find One Consultation
    @GetMapping("/consultations/{id}")
    public ResponseEntity<Consultation> getOneConsultation(@PathVariable Long id) {
        Consultation oneConsultation = consultationService.findOneById(id);
        return new ResponseEntity<>(oneConsultation, HttpStatus.OK);
    }

    // Update One Consultation
    @PutMapping("/consultations/{id}")
    public ResponseEntity<Consultation> updateOneConsultation(@PathVariable Long id, @RequestBody Consultation consultation) {
        Consultation existingConsultation = consultationService.findOneById(id);
        if (existingConsultation != null) {
            existingConsultation.setStatus(consultation.getStatus());
            existingConsultation.setStartTime(consultation.getStartTime());
            existingConsultation.setEndTime(consultation.getEndTime());
            existingConsultation.setConcerns(consultation.getConcerns());
            Consultation updatedConsultation = consultationService.update(consultation);
            return new ResponseEntity<>(updatedConsultation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a consultation by ID
    @DeleteMapping("/consultations/{id}")
    public ResponseEntity<Consultation> deleteConsultation(@PathVariable Long id) {
        consultationService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}