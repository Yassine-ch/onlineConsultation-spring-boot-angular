package com.yassine.javaProject.onlineConsultation.services;

import com.yassine.javaProject.onlineConsultation.models.Doctor;
import com.yassine.javaProject.onlineConsultation.models.Patient;
import com.yassine.javaProject.onlineConsultation.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient register(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient findByEmail(String email) {
        return patientRepository.findByEmail(email);
    }
//    // Find one
//    public Patient findPatient(Long id) {
//        Optional<Patient> optionalPatient = patientRepository.findById(id);
//
//            return optionalPatient.get();
//    }


//
//    // Register Patient
//    public Patient register(Patient newPatient, BindingResult result) {
//
//        Optional<Patient> potentialPatient = patientRepository.findByEmail(newPatient.getEmail());
//        if (potentialPatient.isPresent()) {
//            result.rejectValue("email", "registerError", "Email is Taken");
//        }
//        if (!newPatient.getPassword().equals(newPatient.getConfirmPassword())) {
//            result.rejectValue("password", "registerError", "password does not match");
//        }
//        if (result.hasErrors()) {
//            return null;
//        } else {
//            String hashdPW = BCrypt.hashpw(newPatient.getPassword(), BCrypt.gensalt());
//            newPatient.setPassword(hashdPW);
//            return patientRepository.save(newPatient);
//
//        }
//
//    }
//
//    // Login Patient
//
//    public Patient login(LoginPatient newLoginObject, BindingResult result) {
//        Optional<Patient> potentialLogin = patientRepository.findByEmail(newLoginObject.getEmail());
//        if (!potentialLogin.isPresent()) {
//            result.rejectValue("email", "loginError", "email not found");
//        } else {
//            Patient actualPatient = potentialLogin.get();
//            if (!BCrypt.checkpw(newLoginObject.getPassword(), actualPatient.getPassword())) {
//                result.rejectValue("password", "loginError", "password incorrect");
//            } if (result.hasErrors()) {
//                return null;
//            } else {
//                return actualPatient;
//            }
//        }
//        return null;
//    }




    // Display all Patients
    public List<Patient> allPatients() {
        return patientRepository.findAll();
    }

    // Create a patient
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);

    }

    // Find one
    public Patient findPatient(Long id) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if (optionalPatient.isPresent()) {
            return optionalPatient.get();
        } else {
            return null;
        }
    }


    // Delete a patient
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    // Update a patient
    public Patient updatePatient(Patient patient) {
        return patientRepository.save(patient);
    }

}