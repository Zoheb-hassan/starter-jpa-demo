package com.home.tut;

import com.home.tut.dao.EmailDistributionList;
import com.home.tut.dao.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaStarterUpdate {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Employee employee = entityManager.find(Employee.class, 1);
        /*EmailDistributionList emailDistributionList = entityManager.find(EmailDistributionList.class, 9);
        employee.addMailDl(emailDistributionList);
        emailDistributionList.addEmployee(employee);*/
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        /*entityManager.persist(employee);
        entityManager.persist(emailDistributionList);*/
        entityManager.remove(employee);
        transaction.commit();
    }
}
