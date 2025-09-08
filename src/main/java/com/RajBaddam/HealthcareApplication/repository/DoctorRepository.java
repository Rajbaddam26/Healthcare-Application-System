package com.RajBaddam.HealthcareApplication.repository;

import com.RajBaddam.HealthcareApplication.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {


    @Autowired
    DoctorRepository doctorRepository = null;

    public default boolean existsByEmail(String email) {
        return doctorRepository.existsByEmail(email);
    }

    public default boolean existsByPhone(String phone) {
        return doctorRepository.existsByPhone(phone);
    }

}
