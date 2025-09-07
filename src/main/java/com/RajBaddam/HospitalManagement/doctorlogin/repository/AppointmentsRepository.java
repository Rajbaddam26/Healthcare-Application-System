package com.RajBaddam.HospitalManagement.doctorlogin.repository;

import com.RajBaddam.HospitalManagement.doctorlogin.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentsRepository extends JpaRepository<Appointment, Long> {

}
