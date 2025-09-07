package com.RajBaddam.HospitalManagement.doctorlogin.controller;

import com.RajBaddam.HospitalManagement.doctorlogin.entity.Medicine;
import com.RajBaddam.HospitalManagement.doctorlogin.repository.MedicinesRepository;
import com.RajBaddam.HospitalManagement.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeNotFoundException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:4200/", "https://hospital-managament-system-front-end.vercel.app/"})
@RestController
@RequestMapping("api/v2")
public class MedicineController {

    private MedicinesRepository medicinesRepository;
    @Autowired
    private PatientRepository patientRepository;

    public MedicineController(MedicinesRepository medicinesRepository) {
        this.medicinesRepository = medicinesRepository;
    }

    @PostMapping("insert")
    public Medicine createMedicine(@RequestBody Medicine medicine) {
        return medicinesRepository.save(medicine);
    }

    @Autowired
    MedicinesRepository medicinesRepositories;

    @GetMapping("medicines")
    public List<Medicine> getAllMedicines() {
        return medicinesRepositories.findAll();
    }

    @GetMapping("medicines/{id}")
    public  ResponseEntity<Medicine> getMedicineById(@PathVariable Long id, Medicine medicine) {
        Optional<Medicine> medicineOptional = medicinesRepositories.findById(id);
        if (medicineOptional.isPresent()) {
            medicine = medicineOptional.get();
            return ResponseEntity.ok(medicine);
        }
        else {
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("medicines/{id}")
    public ResponseEntity<Medicine> updateMedicine(@PathVariable Long id, @RequestBody Medicine medicine) throws AttributeNotFoundException {
        Medicine medicines = medicinesRepositories.findById(id).orElseThrow(()->new AttributeNotFoundException("medicine not found by id:"+id));
        medicines.setDrugName(medicine.getDrugName());
        medicines.setStock(medicine.getStock());
        Medicine medicineData = medicinesRepositories.save(medicines);
        return ResponseEntity.ok(medicineData);
    }

    @DeleteMapping("medicines/{id}")
    public ResponseEntity<?> deleteMedicine(@PathVariable Long id) {
        Optional<Medicine> medicineOptional = medicinesRepositories.findById(id);
        if (medicineOptional.isPresent()) {
            medicinesRepositories.deleteById(id);
            return ResponseEntity.ok().body("{\"message\": \"Medicine deleted successfully\"}"); // Return 200 OK with no body
        } else {
            return ResponseEntity.notFound().build(); // Return 404 Not Found with no body
        }
    }
}
