package com.inahon.repository;


import com.inahon.model.Appointment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class AppointmentRepositoryImpl {
    private SessionFactory sessionFactory;

    public AppointmentRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createAppointment(Appointment appointment) {
        Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(appointment);
            transaction.commit();
        }


    public Appointment getAppointmentById(int appointmentId) {
        Session session = sessionFactory.openSession();
            return session.get(Appointment.class, appointmentId);
        }


    public void updateAppointment(Appointment appointment) {
        Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.update(appointment);
            transaction.commit();
    }

    public void deleteAppointment(int appointmentId) {
        Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            Appointment appointment = session.get(Appointment.class, appointmentId);
            if (appointment != null) {
                session.delete(appointment);
            }
            transaction.commit();
        }


    public List<Appointment> getAllAppointment() {
        Session session = sessionFactory.openSession();
            return session.createQuery("from Patient", Appointment.class).list();
        }

}
