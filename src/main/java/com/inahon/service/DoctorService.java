package com.inahon.service;

import com.inahon.model.Doctor;
import com.inahon.repository.DoctorRepositoryImpl;

import java.util.List;

public class DoctorService {
    private DoctorRepositoryImpl doctorRepository;

    public DoctorService(DoctorRepositoryImpl doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public void createDoctor(Doctor doctor) {
        doctorRepository.createDoctor(doctor);
    }

    public List<Doctor> findAllDoctors() {
        return doctorRepository.findAllDoctors();
    }

    public Doctor getDoctorById(int doctorId) {
        return doctorRepository.findDoctorById(doctorId);
    }
    public void updateDoctor(Doctor doctor) {
        doctorRepository.updateDoctor(doctor);
    }
    public void deleteDoctor(int doctorId) {
        doctorRepository.deleteDoctor(doctorId);
    }
}
