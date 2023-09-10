package com.yassine.javaProject.onlineConsultation.controllers;



import com.yassine.javaProject.onlineConsultation.models.LoginPatient;
import com.yassine.javaProject.onlineConsultation.models.Patient;
import com.yassine.javaProject.onlineConsultation.services.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

//GET ALL PATIENT
@GetMapping("/allPatients")
public ResponseEntity<List<Patient>> getAllPatients() {
    List<Patient> patients = patientService.allPatients();
    if (patients.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(patients, HttpStatus.OK);
}

    @PostMapping("/logins")
    public ResponseEntity<?> login(@Valid @RequestBody LoginPatient loginRequest, BindingResult result) {
        if (result.hasErrors()) {
            // Handle validation errors here
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }

        Patient patient = patientService.login(loginRequest, result);

        if (patient != null) {
            return new ResponseEntity<>(patient, HttpStatus.OK);
        } else if (result.hasErrors()) {
            // Handle login errors here
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.UNAUTHORIZED);
        } else {
            return new ResponseEntity<>("An error occurred during the login process.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //    @PostMapping("/register")
//    public Patient register(@RequestBody Patient patient) {
//        return patientService.register(patient);
//    }
//Reg
//    @PostMapping
//    public Patient registerPatient(@RequestBody Patient patient,BindingResult result){
//        return patientService.register(patient,HttpStatus.OK);
//    }

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
    //Update
    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient updatedPatient) {
        Optional<Patient> updated = patientService.updatePatient(id, updatedPatient);
        if (updated.isPresent()) {
            return ResponseEntity.ok(updated.get());
        }
        return ResponseEntity.notFound().build();
    }
    //COUNT
    @GetMapping("/patients/count")
    public ResponseEntity<Map<String, Long>> getNumberOfPatients() {
        long count = patientService.getNumberOfPatients();
        return ResponseEntity.ok(Collections.singletonMap("count", count));
    }
}