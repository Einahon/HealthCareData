package com.inahon.service;

import com.inahon.model.Appointment;
import com.inahon.repository.AppointmentRepositoryImpl;

import java.util.List;

public class AppointmentService {
    private final AppointmentRepositoryImpl appointmentRepository;
    public AppointmentService(AppointmentRepositoryImpl appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public void createAppointment(Appointment appointment) {
        appointmentRepository.createAppointment(appointment);
    }

    public Appointment getAppointmentById( int appointmentId) {
        return appointmentRepository.getAppointmentById(appointmentId);
    }
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.getAllAppointment();
    }
    public void updateAppointment(Appointment appointment) {
        appointmentRepository.updateAppointment(appointment);
    }
    public void deleteAppointment(int appointmentId) {
        appointmentRepository.deleteAppointment(appointmentId);
    }
}
