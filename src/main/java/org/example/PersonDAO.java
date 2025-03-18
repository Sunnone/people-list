package org.example;

import org.example.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class PersonDAO {

    public void addPerson(Person person) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(person);
            transaction.commit();
        }
    }

    public List<Person> getAllPeople() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Person", Person.class).list();
        }
    }

    public void updatePerson(Person person){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(person);
            transaction.commit();
        }
    }

    public void deletePerson(Person person){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.delete(person);
            transaction.commit();
        }
    }

    public Person getById(Long id){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Person where id = :id", Person.class)
                    .setParameter("id", id)
                    .uniqueResult();
        }
    }
}