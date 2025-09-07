package com.RajBaddam.HospitalManagement.controller;

import com.RajBaddam.HospitalManagement.entity.Patient;
import com.RajBaddam.HospitalManagement.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeNotFoundException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:4200/", "https://hospital-managament-system-front-end.vercel.app/"})
@RestController
@RequestMapping("/api/v1")
public class PatientController {

    private PatientRepository PatientRepository;

    public PatientController(PatientRepository PatientRepository) {
        this.PatientRepository = PatientRepository;
    }
    @PostMapping("/insert")
    public Patient createPatient(@RequestBody Patient patient) {
        return PatientRepository.save(patient);

    }

    @Autowired
    PatientRepository patientRepository;
    @GetMapping("patients")
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
    @DeleteMapping("patients/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Long id) {
        Optional<Patient> appointmentOptional = patientRepository.findById(id);
        if (appointmentOptional.isPresent()) {
            patientRepository.deleteById(id);
            return ResponseEntity.ok().body("{\"message\": \"Appointment deleted successfully\"}"); // Return 200 OK with no body
        } else {
            return ResponseEntity.notFound().build(); // Return 404 Not Found with no body
        }
    }

    @GetMapping("patients/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) throws AttributeNotFoundException {
        Patient patients = patientRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("patient not found by id:"+id));
        return ResponseEntity.ok(patients);

    }

    @PutMapping("patients/{id}")
    public ResponseEntity<?> updatePatientById(@PathVariable Long id, @RequestBody Patient patientDelete) throws AttributeNotFoundException {
        Patient patients = patientRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("patient not found by id:"+id));
        patients.setName(patientDelete.getName());
        patients.setAge(patientDelete.getAge());
        patients.setBlood(patientDelete.getBlood());
        patients.setDose(patientDelete.getDose());
        patients.setFees(patientDelete.getFees());
        patients.setPrescription(patientDelete.getPrescription());
        patients.setUrgency(patientDelete.getUrgency());
        Patient savePatient =   patientRepository.save(patients);
        return ResponseEntity.ok(savePatient);

    }

}
