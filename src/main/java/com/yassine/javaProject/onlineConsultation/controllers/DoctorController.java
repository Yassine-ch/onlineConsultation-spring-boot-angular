package com.yassine.javaProject.onlineConsultation.controllers;

import com.yassine.javaProject.onlineConsultation.models.Doctor;
import com.yassine.javaProject.onlineConsultation.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // Create One Doctor
    @PostMapping(value = "/doctors")
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
        Doctor doctorCreated = doctorService.createDoctor(doctor);
        return new ResponseEntity<>(doctorCreated, HttpStatus.CREATED);
    }

    // Get All Doctors
    @GetMapping("/doctors")
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> allDoctors = doctorService.allDoctors();
        return new ResponseEntity<>(allDoctors, HttpStatus.OK);
    }

    // Find One Doctor
    @GetMapping("/doctors/{id}")
    public ResponseEntity<Doctor> getOneDoctor(@PathVariable Long id) {
        Doctor oneDoctor = doctorService.findDoctor(id);
        return new ResponseEntity<>(oneDoctor, HttpStatus.OK);
    }

    // Update One Doctor


    @PutMapping("/doctors/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor) {
        Doctor doctorUpdated = doctorService.updateDoctor(doctor);
        return new ResponseEntity<>(doctorUpdated, HttpStatus.OK);
    }



//	@PutMapping("/doctors/{id}")
//	public ResponseEntity<Doctor> updateOneDoctor(@PathVariable Long id, @RequestBody Doctor doctor) {
//		Doctor existingDoctor = doctorService.findDoctor(id);
//		if (existingDoctor != null) {
//			existingDoctor.setFirstName(doctor.getFirstName());
//			existingDoctor.setLastName(doctor.getLastName());
//			existingDoctor.setEmail(doctor.getEmail());
//			existingDoctor.setPassword(doctor.getPassword());
//			existingDoctor.setConfirm(doctor.getConfirm());
//			Doctor updatedDoctor = doctorService.updateDoctor(doctor);
//			return new ResponseEntity<>(updatedDoctor, HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}

    // Delete a consultation by ID
    @DeleteMapping("/doctors/{id}")
    public ResponseEntity<Doctor> deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}