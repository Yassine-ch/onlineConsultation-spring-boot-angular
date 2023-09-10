package com.yassine.javaProject.onlineConsultation.services;

import com.yassine.javaProject.onlineConsultation.models.Doctor;
import com.yassine.javaProject.onlineConsultation.repositories.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    // Display all Doctors
    public List<Doctor> allDoctors() {
        return doctorRepository.findAll();
    }

    // Create a doctor
    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);

    }

    // Find one
    public Doctor findDoctor(Long id) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(id);
        if (optionalDoctor.isPresent()) {
            return optionalDoctor.get();
        } else {
            return null;
        }
    }


    // Delete a doctor
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    // Update a doctor
    public Doctor updateDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
    //COUNT
    public long getNumberOfDoctors() {
        return doctorRepository.count();
    }
}