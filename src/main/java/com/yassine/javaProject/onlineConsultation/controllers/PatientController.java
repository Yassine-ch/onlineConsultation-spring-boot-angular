package com.yassine.javaProject.onlineConsultation.controllers;


import com.yassine.javaProject.onlineConsultation.models.Patient;
import com.yassine.javaProject.onlineConsultation.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}