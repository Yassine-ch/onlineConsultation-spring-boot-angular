package com.yassine.javaProject.onlineConsultation.services;

import com.yassine.javaProject.onlineConsultation.models.Medicine;
import com.yassine.javaProject.onlineConsultation.repositories.MedicineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicineService {
    private final MedicineRepository medicineRepository;

    public MedicineService(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    // Display all Medicines
    public List<Medicine> allMedicines() {
        return medicineRepository.findAll();
    }

    // Create a medicine
    public Medicine createMedicine(Medicine medicine) {
        return medicineRepository.save(medicine);

    }

    // Find one
    public Medicine findMedicine(Long id) {
        Optional<Medicine> optionalMedicine = medicineRepository.findById(id);
        if (optionalMedicine.isPresent()) {
            return optionalMedicine.get();
        } else {
            return null;
        }
    }


    // Delete a medicine
    public void deleteMedicine(Long id) {
        medicineRepository.deleteById(id);
    }

    // Update a medicine
    public Medicine updateMedicine(Medicine medicine) {
        return medicineRepository.save(medicine);
    }
}