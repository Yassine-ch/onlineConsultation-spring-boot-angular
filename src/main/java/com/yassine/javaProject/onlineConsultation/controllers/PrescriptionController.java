package com.yassine.javaProject.onlineConsultation.controllers;

import com.yassine.javaProject.onlineConsultation.models.Prescription;
import com.yassine.javaProject.onlineConsultation.services.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    // Create One Prescription
    @PostMapping(value = "/prescriptions")
    public ResponseEntity<Prescription> createPrescription(@RequestBody Prescription prescription) {
        Prescription prescriptionCreated = prescriptionService.createPrescription(prescription);
        return new ResponseEntity<>(prescriptionCreated, HttpStatus.CREATED);
    }

    // Get All Prescriptions
    @GetMapping("/prescriptions")
    public ResponseEntity<List<Prescription>> getAllPrescriptions() {
        List<Prescription> allPrescriptions = prescriptionService.allPrescriptions();
        return new ResponseEntity<>(allPrescriptions, HttpStatus.OK);
    }

    // Find One Prescription
    @GetMapping("/prescriptions/{id}")
    public ResponseEntity<Prescription> getOnePrescription(@PathVariable Long id) {
        Prescription onePrescription = prescriptionService.findPrescription(id);
        return new ResponseEntity<>(onePrescription, HttpStatus.OK);
    }

    // Update One Prescription
    @PutMapping("/prescriptions/{id}")
    public ResponseEntity<Prescription> updateOnePrescription(@PathVariable Long id, @RequestBody Prescription prescription) {
        Prescription existingPrescription = prescriptionService.findPrescription(id);
        if (existingPrescription != null) {

            Prescription updatedPrescription = prescriptionService.updatePrescription(prescription);
            return new ResponseEntity<>(updatedPrescription, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a consultation by ID
    @DeleteMapping("/prescriptions/{id}")
    public ResponseEntity<Prescription> deletePrescription(@PathVariable Long id) {
        prescriptionService.deletePrescription(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}