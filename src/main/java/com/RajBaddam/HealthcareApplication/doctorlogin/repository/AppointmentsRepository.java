package com.RajBaddam.HealthcareApplication.doctorlogin.repository;

import com.RajBaddam.HealthcareApplication.doctorlogin.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentsRepository extends JpaRepository<Appointment, Long> {

}
