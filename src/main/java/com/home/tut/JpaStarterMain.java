package com.home.tut;

import com.home.tut.dao.AccessCard;
import com.home.tut.dao.Employee;
import com.home.tut.dao.EmployeeType;

import javax.persistence.*;
import java.time.LocalDateTime;

public class JpaStarterMain {

    public static void main(String[] args) {

    }

    /**
     * Delete a Employee Record
     *
     * @param id
     */
    private static void dropEmployee(int id) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
        transaction.commit();
    }

    /**
     * Update a record
     */
    private static void updateRecord(int id, String name, EmployeeType employeeType) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Employee employee = entityManager.find(Employee.class, id);
        employee.setName(name);
        employee.setEmployeeType(employeeType);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        transaction.commit();
    }


    /**
     * Fetching an existing Employee Record From DB
     */
    private static String fetchEmployee(int id) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Employee employee = entityManager.find(Employee.class, id);
        return employee.toString();

    }


    /**
     * Method showing the Employee Creation & Persistence into DB
     */
    private static void createEmployee() {

        Employee employee = new Employee();
        employee.setName("Namit");
        employee.setEmployeeType(EmployeeType.FULL_TIME);
        employee.setDateOfBirth(LocalDateTime.now());
        employee.setNonPersistedValue("This doesn't Matter");

        AccessCard accessCard = new AccessCard();
        accessCard.setFirmwareVersion("1.0.12");
        accessCard.setOrganization("Orcl");
        employee.setAccessCard(accessCard);
        accessCard.setCardOwnedBy(employee);

        Employee employee2 = new Employee();
        employee2.setName("Shobit");
        employee2.setEmployeeType(EmployeeType.PART_TIME);
        employee2.setDateOfBirth(LocalDateTime.MIN);
        employee2.setNonPersistedValue("This doesn't Matter");

        AccessCard accessCard2 = new AccessCard();
        accessCard2.setFirmwareVersion("1.0.12");
        accessCard2.setOrganization("Orcl");
        employee2.setAccessCard(accessCard2);
        accessCard2.setCardOwnedBy(employee2);

        Employee employee3 = new Employee();
        employee3.setName("Lohit");
        employee3.setEmployeeType(EmployeeType.CONTRACT);
        employee3.setDateOfBirth(LocalDateTime.MIN);
        employee3.setNonPersistedValue("This doesn't Matter");

        AccessCard accessCard3 = new AccessCard();
        accessCard3.setFirmwareVersion("1.0.12");
        accessCard3.setOrganization("Orcl");
        employee3.setAccessCard(accessCard3);
        accessCard3.setCardOwnedBy(employee3);

        //Retrieve Entity Manager(service for managing entities) From Factory Method by providing the
        //Persistence-unit name from persistence.xml from under META-INF
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //Retrieve the Entity Transaction For Managing the Transaction i.e., begin & commit
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(employee);
        entityManager.persist(accessCard);
        entityManager.persist(employee2);
        entityManager.persist(accessCard2);
        entityManager.persist(employee3);
        entityManager.persist(accessCard3);
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

    private static String fetchAccessCard(int id) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AccessCard accessCard = entityManager.find(AccessCard.class, id);
        return accessCard.toString();
    }
}
