package com.yassine.javaProject.onlineConsultation.controllers;

import com.yassine.javaProject.onlineConsultation.models.Consultation;
import com.yassine.javaProject.onlineConsultation.services.ConsultationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200") //To Link with Angular
@RequestMapping("/api/consultations")
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;

    // Create a new consultation
    @PostMapping
    public ResponseEntity<Consultation> createConsultation(@RequestBody Consultation consultation) {
        Consultation createdConsultation = consultationService.create(consultation);
        return new ResponseEntity<>(createdConsultation, HttpStatus.CREATED);
    }

    // Get all consultations
    @GetMapping
    public ResponseEntity<List<Consultation>> getAllConsultations() {
        List<Consultation> consultations = consultationService.findAllConsultation();
        return new ResponseEntity<>(consultations, HttpStatus.OK);
    }

    // Get a specific consultation by ID
    @GetMapping("/{id}")
    public ResponseEntity<Consultation> getConsultationById(@PathVariable Long id) {
        Consultation consultation = consultationService.findOneById(id);
        if (consultation != null) {
            return new ResponseEntity<>(consultation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update a consultation
    @PutMapping("/{id}")
    public ResponseEntity<Consultation> updateConsultation(@PathVariable Long id, @RequestBody Consultation consultationDetails) {
        Consultation existingConsultation = consultationService.findOneById(id);
        if (existingConsultation != null) {
            existingConsultation.setStartTime(consultationDetails.getStartTime());
            existingConsultation.setEndTime(consultationDetails.getEndTime());
            existingConsultation.setConcerns(consultationDetails.getConcerns());
            existingConsultation.setMedications(consultationDetails.getMedications());
            existingConsultation.setDiseases(consultationDetails.getDiseases());
            // add other fields as needed
            Consultation updatedConsultation = consultationService.update(existingConsultation);
            return new ResponseEntity<>(updatedConsultation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a consultation by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Consultation> deleteConsultation(@PathVariable Long id) {
        consultationService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
