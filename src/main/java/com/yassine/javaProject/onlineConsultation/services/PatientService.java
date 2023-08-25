package com.yassine.javaProject.onlineConsultation.services;

import com.yassine.javaProject.onlineConsultation.models.Patient;
import com.yassine.javaProject.onlineConsultation.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PatientService implements UserDetailsService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Patient save(Patient patient) {
        patient.setPassword(bCryptPasswordEncoder.encode(patient.getPassword()));
        return patientRepository.save(patient);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Patient patient = patientRepository.findByEmail(email);
        if (patient == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        return new User(patient.getEmail(), patient.getPassword(), new ArrayList<>());
    }
}