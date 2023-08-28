//package com.yassine.javaProject.onlineConsultation.controllers;
//
//import com.yassine.javaProject.onlineConsultation.models.Patient;
//import com.yassine.javaProject.onlineConsultation.services.PatientService;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//
//    @Autowired
// PatientService patientService;
//
//    @PostMapping("/register")
//    public ResponseEntity<?> registerUser(@Valid @RequestBody Patient patient) {
//        if(patientService.loadUserByUsername(patient.getEmail()) != null){
//            return new ResponseEntity<>("Email already in use.", HttpStatus.BAD_REQUEST);
//        }
//        patientService.save(patient);
//        return new ResponseEntity<>("Registered successfully.", HttpStatus.CREATED);
//    }
//
//    // Login is typically handled by Spring Security, so you may not need an explicit endpoint for it.
//    // But if you want a custom endpoint:
//    @PostMapping("/login")
//    public ResponseEntity<?> loginUser(@Valid @RequestBody Patient patient) {
//        // Implementation will depend on how you setup Spring Security
//        // For instance, you might just return a JWT here
//        return new ResponseEntity<>("Logged in successfully.", HttpStatus.OK);
//    }
//}
//
//
//
