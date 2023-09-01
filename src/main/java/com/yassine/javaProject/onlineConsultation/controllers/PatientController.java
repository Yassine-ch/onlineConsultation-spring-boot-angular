package com.yassine.javaProject.onlineConsultation.controllers;


import com.yassine.javaProject.onlineConsultation.models.Doctor;
import com.yassine.javaProject.onlineConsultation.models.Patient;
import com.yassine.javaProject.onlineConsultation.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/register")
    public Patient register(@RequestBody Patient patient) {
        return patientService.register(patient);
    }

    @PostMapping("/login")
    public Patient login(@RequestBody Patient patient) {
        Patient existingPatient = patientService.findByEmail(patient.getEmail());
        if (existingPatient != null && existingPatient.getPassword().equals(patient.getPassword())) {
            return existingPatient;
        }
        return null;
    }


    // Create One Patient
    @PostMapping(value = "/patients")
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        Patient patientCreated = patientService.createPatient(patient);
        return new ResponseEntity<>(patientCreated, HttpStatus.CREATED);
    }
    // Find One Patient
    @GetMapping("/patients/{id}")
    public ResponseEntity<Patient> getOnePatient(@PathVariable Long id) {
        Patient onePatient = patientService.findPatient(id);
        return new ResponseEntity<>(onePatient, HttpStatus.OK);
    }
}