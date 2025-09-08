package com.RajBaddam.HealthcareApplication.doctorlogin.controller;


import com.RajBaddam.HealthcareApplication.doctorlogin.entity.Appointment;
import com.RajBaddam.HealthcareApplication.doctorlogin.repository.AppointmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:4200/", "https://healthcare-application-system-front-end.vercel.app/"})
@RestController
@RequestMapping("api/v3")
public class AppointmentController {

    private AppointmentsRepository appointmentsRepository;
    public AppointmentController(AppointmentsRepository appointmentsRepository) {
        this.appointmentsRepository = appointmentsRepository;
    }

    @PostMapping("insert")
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentsRepository.save(appointment);
    }

    @Autowired
    AppointmentsRepository appointmentsRepositores;

    @GetMapping("appointments")
    public List<Appointment> getAllAppointments() {
        return appointmentsRepositores.findAll();
    }
    @DeleteMapping("appointments/{id}")
    public ResponseEntity<?> deleteAppointment(@PathVariable Long id) {
        Optional<Appointment> appointmentOptional = appointmentsRepository.findById(id);
        if (appointmentOptional.isPresent()) {
            appointmentsRepository.deleteById(id);
            return ResponseEntity.ok().body("{\"message\": \"Appointment deleted successfully\"}"); // Return 200 OK with no body
        } else {
            return ResponseEntity.notFound().build(); // Return 404 Not Found with no body
        }
    }
}
