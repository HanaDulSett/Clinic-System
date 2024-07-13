package com.utem.project.cms.service;

import com.utem.project.cms.model.Patient;
import java.util.List;

public interface PatientService {

    List<Patient> getAllPatients();

    Patient savePatient(Patient patient);

    Patient updatePatient(Patient patient);

    void deletePatientById(Long id);

    Patient getPatientById(Long id);

    boolean isDuplicateIcNo(String icNo); // Define the method to check for duplicate IC number
}
