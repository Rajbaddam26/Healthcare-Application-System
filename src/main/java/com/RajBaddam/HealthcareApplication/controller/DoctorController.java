package com.RajBaddam.HealthcareApplication.controller;

import com.RajBaddam.HealthcareApplication.entity.Doctor;
import com.RajBaddam.HealthcareApplication.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeNotFoundException;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200/", "https://healthcare-application-system-front-end.vercel.app/"})
@RestController
@RequestMapping("/api/v4/doctor")
public class DoctorController {
    private DoctorRepository DoctorRepository;

    public DoctorController(DoctorRepository doctorRepository) {
        DoctorRepository = doctorRepository;
    }

    @PostMapping("/register")
    public Doctor registerDoctor(@RequestBody Doctor doctor) {
        return DoctorRepository.save(doctor);
    }

    @Autowired
    DoctorRepository doctorRepository;

    @GetMapping("doctorlist")
    public List<Doctor> getAllDoctors() {
        return DoctorRepository.findAll();
    }

    @GetMapping("doctorlist/{id}")
    public  ResponseEntity<Doctor>getDoctorById(@PathVariable Long id) throws AttributeNotFoundException{
        Doctor doctor = doctorRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Doctor not found this id is invalid: "+id));
        return ResponseEntity.ok(doctor);
    }


    @GetMapping("/checkEmailExists")
    public boolean checkEmailExists(@RequestParam String email) {
        return doctorRepository.existsByEmail(email);
    }

    @GetMapping("/checkPhoneExists")
    public boolean checkPhoneExists(@RequestParam String phone) {
        return doctorRepository.existsByPhone(phone);
    }



}
