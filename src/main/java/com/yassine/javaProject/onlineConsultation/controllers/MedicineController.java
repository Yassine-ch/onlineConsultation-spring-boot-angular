package com.yassine.javaProject.onlineConsultation.controllers;

import com.yassine.javaProject.onlineConsultation.models.Medicine;
import com.yassine.javaProject.onlineConsultation.services.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    // Create One Medicine
    @PostMapping(value = "/medicines")
    public ResponseEntity<Medicine> createMedicine(@RequestBody Medicine medicine) {
        Medicine medicineCreated = medicineService.createMedicine(medicine);
        return new ResponseEntity<>(medicineCreated, HttpStatus.CREATED);
    }

    // Get All Medicines
    @GetMapping("/medicines")
    public ResponseEntity<List<Medicine>> getAllMedicines() {
        List<Medicine> allMedicines = medicineService.allMedicines();
        return new ResponseEntity<>(allMedicines, HttpStatus.OK);
    }

    // Find One Medicine
    @GetMapping("/medicines/{id}")
    public ResponseEntity<Medicine> getOneMedicine(@PathVariable Long id) {
        Medicine oneMedicine = medicineService.findMedicine(id);
        return new ResponseEntity<>(oneMedicine, HttpStatus.OK);
    }

    // Update One Medicine
    @PutMapping("/medicines/{id}")
    public ResponseEntity<Medicine> updateOneMedicine(@PathVariable Long id, @RequestBody Medicine medicine) {
        Medicine existingMedicine = medicineService.findMedicine(id);
        if (existingMedicine != null) {
            existingMedicine.setMedicine(medicine.getMedicine());
            existingMedicine.setMorning(medicine.getMorning());
            existingMedicine.setAfternoon(medicine.getAfternoon());
            existingMedicine.setNight(medicine.getNight());
            Medicine updatedMedicine = medicineService.updateMedicine(medicine);
            return new ResponseEntity<>(updatedMedicine, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a consultation by ID
    @DeleteMapping("/medicines/{id}")
    public ResponseEntity<Medicine> deleteMedicine(@PathVariable Long id) {
        medicineService.deleteMedicine(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}