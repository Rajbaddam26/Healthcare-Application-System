package com.RajBaddam.HealthcareApplication.doctorlogin.repository;

import com.RajBaddam.HealthcareApplication.doctorlogin.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicinesRepository extends JpaRepository<Medicine, Long> {

}
