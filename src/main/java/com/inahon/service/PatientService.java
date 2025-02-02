package com.inahon.service;

import com.inahon.model.Patient;
import com.inahon.repository.PatientRepositoryImpl;

import java.util.List;

public class PatientService {
    private PatientRepositoryImpl patientRepository;
    public PatientService(PatientRepositoryImpl patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void createPatient(Patient patient) {
        patientRepository.createPatient(patient);
    }

    public Patient getPatientById(int id) {
        return patientRepository.getPatientById(id);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.getAllPatients();
    }
    public void updatePatient(Patient patient) {
        patientRepository.updatePatient(patient);
    }
    public void deletePatient(int id) {
            patientRepository.deletePatient(id);

        }
    }

