package com.home.tut;

import com.home.tut.dao.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaStarterMain {

    public static void main(String[] args) {

        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Namit");

        //Retrieve Entity Manager(service for managing entities) From Factory Method by providing the
        //Persistence-unit name from persistence.xml from under META-INF
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //Retrieve the Entity Transaction For Managing the Transaction i.e., begin & commit
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(employee);
        entityTransaction.commit();
    }
}
