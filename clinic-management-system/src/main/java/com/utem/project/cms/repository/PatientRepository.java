package com.utem.project.cms.repository;

import com.utem.project.cms.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    boolean existsByIcNo(String icNo);
}
