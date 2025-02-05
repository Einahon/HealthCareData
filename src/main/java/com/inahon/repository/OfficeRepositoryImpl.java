package com.inahon.repository;

import com.inahon.model.Office;
import com.inahon.model.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class OfficeRepositoryImpl {
    private SessionFactory sessionFactory;

    public OfficeRepositoryImpl(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }

    public void createOffice(Office office) {
        Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.persist(office);
            transaction.commit();
        }


    public Office getOfficeById(int officeId) {
        Session session = sessionFactory.openSession();
            return session.get(Office.class, officeId);
        }

    public void updateOffice(Office office) {
        Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.merge(office);
            transaction.commit();
    }

    public void deleteOffice(int officeId) {
        Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            Office office = session.get(Office.class, officeId);
            if (office != null) {
                session.remove(office);
            }
            transaction.commit();
        }

    public List<Office> getAllOffices() {
        Session session = sessionFactory.openSession();
            return session.createQuery("from Office ", Office.class).list();
        }

    }