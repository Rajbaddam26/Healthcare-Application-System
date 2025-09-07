package com.RajBaddam.HospitalManagement.doctorlogin.repository;

import com.RajBaddam.HospitalManagement.doctorlogin.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicinesRepository extends JpaRepository<Medicine, Long> {

}
