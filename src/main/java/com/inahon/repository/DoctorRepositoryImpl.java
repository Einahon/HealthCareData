package com.inahon.repository;

import com.inahon.model.Doctor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class DoctorRepositoryImpl {
    private SessionFactory sessionFactory;
    public DoctorRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createDoctor(Doctor doctor) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(doctor);
        tx.commit();
    }

    public List<Doctor> findAllDoctors() {
        Session session = sessionFactory.openSession();
        return session.createQuery("from Doctor", Doctor.class).list();
    }

    public void updateDoctor(Doctor doctor) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(doctor);
        tx.commit();
    }

    public void deleteDoctor(int doctorId) {
        Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            Doctor doctor = session.get(Doctor.class, doctorId);
            if (doctor != null) {
                session.delete(doctor);
            }
            transaction.commit();

    }

    public Doctor findDoctorById(int doctorId) {
        Session session = sessionFactory.openSession();
        return session.get(Doctor.class, doctorId);
    }

}
