package org.example;

import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void addPerson(Person person) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(person);
            transaction.commit();
        }
    }

    @Transactional
    public List<Person> getAllPeople() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Person", Person.class).list();
        }
    }

    public void updatePerson(Person person){
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(person);
            transaction.commit();
        }
    }

    public void deletePerson(Person person){
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.delete(person);
            transaction.commit();
        }
    }

    public Person getById(Long id){
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Person where id = :id", Person.class)
                    .setParameter("id", id)
                    .uniqueResult();
        }
    }
}