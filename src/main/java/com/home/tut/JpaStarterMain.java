package com.home.tut;

import com.home.tut.dao.Employee;
import com.home.tut.dao.EmployeeType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class JpaStarterMain {

    public static void main(String[] args) {

        Employee employee = new Employee();
        employee.setName("Namit");
        employee.setEmployeeType(EmployeeType.FULL_TIME);
        employee.setDateOfBirth(LocalDateTime.now());
        employee.setNonPersistedValue("This doesn't Matter");


        Employee employee2 = new Employee();
        employee2.setName("Shobit");
        employee2.setEmployeeType(EmployeeType.PART_TIME);
        employee2.setDateOfBirth(LocalDateTime.MIN);
        employee2.setNonPersistedValue("This doesn't Matter");

        Employee employee3 = new Employee();
        employee3.setName("Lohit");
        employee3.setEmployeeType(EmployeeType.CONTRACT);
        employee3.setDateOfBirth(LocalDateTime.MIN);
        employee3.setNonPersistedValue("This doesn't Matter");

        //Retrieve Entity Manager(service for managing entities) From Factory Method by providing the
        //Persistence-unit name from persistence.xml from under META-INF
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //Retrieve the Entity Transaction For Managing the Transaction i.e., begin & commit
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(employee);
        entityTransaction.commit();

        entityTransaction.begin();
        entityManager.persist(employee2);
        entityTransaction.commit();

        entityTransaction.begin();
        entityManager.persist(employee3);
        entityTransaction.commit();
        /** Closing the Persistence Context depending on the hbm2ddl config the db behaves i.e.,
         1) drops table if value = create-drop
         2) validates the entity with existing table if value = validate
         3) updates Schema as per the entity definition value = update
         4) only create if value = create
        */
        entityManager.close();
        entityManagerFactory.close();
        System.out.println(employee);
    }
}
