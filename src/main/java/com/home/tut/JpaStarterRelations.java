package com.home.tut;

import com.home.tut.dao.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class JpaStarterRelations {

    public static void main(String[] args) {

        employeeStub();
    }

    private static void employeeStub() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Employee employee = new Employee();
        employee.setName("Lohit");
        employee.setEmployeeType(EmployeeType.FULL_TIME);
        employee.setDateOfBirth(LocalDateTime.now());
        employee.setNonPersistedValue("This doesn't Matter");

        AccessCard accessCard = new AccessCard();
        accessCard.setFirmwareVersion("1.0.12");
        accessCard.setOrganization("Orcl");
        employee.setAccessCard(accessCard);
        accessCard.setCardOwnedBy(employee);

        PaySlip paySlip = new PaySlip();
        paySlip.setEmployee(employee);
        paySlip.setCycleEndDate(LocalDateTime.MIN);
        paySlip.setCycleEndDate(LocalDateTime.now());
        paySlip.setSalary(1000);

        PaySlip paySlip2 = new PaySlip();
        paySlip2.setEmployee(employee);
        paySlip2.setCycleEndDate(LocalDateTime.MIN);
        paySlip2.setCycleEndDate(LocalDateTime.now());
        paySlip2.setSalary(1000);

        employee.setPaySlips(List.of(paySlip, paySlip2));

        Employee employee2 = new Employee();
        employee2.setName("Lohit");
        employee2.setEmployeeType(EmployeeType.FULL_TIME);
        employee2.setDateOfBirth(LocalDateTime.now());
        employee2.setNonPersistedValue("This doesn't Matter");

        AccessCard accessCard2 = new AccessCard();
        accessCard2.setFirmwareVersion("1.0.12");
        accessCard2.setOrganization("Orcl");
        employee2.setAccessCard(accessCard2);
        accessCard2.setCardOwnedBy(employee2);

        PaySlip paySlip3 = new PaySlip();
        paySlip3.setEmployee(employee2);
        paySlip3.setCycleEndDate(LocalDateTime.MIN);
        paySlip3.setCycleEndDate(LocalDateTime.now());
        paySlip3.setSalary(1000);

        employee2.setPaySlips(List.of(paySlip3));

        EmailDistributionList emailDistributionList = new EmailDistributionList();
        emailDistributionList.setDlName("zo_directs");
        emailDistributionList.setEmployees(List.of(employee, employee2));

        EmailDistributionList emailDistributionList2 = new EmailDistributionList();
        emailDistributionList2.setDlName("coe_engineering");
        emailDistributionList2.setEmployees(List.of(employee2));

        employee.setEmailDistributionLists(List.of(emailDistributionList));
        employee2.setEmailDistributionLists(List.of(emailDistributionList, emailDistributionList2));

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(employee);
        entityManager.persist(accessCard);
        entityManager.persist(paySlip);
        entityManager.persist(paySlip2);
        entityManager.persist(employee2);
        entityManager.persist(paySlip3);
        entityManager.persist(accessCard2);
        entityManager.persist(emailDistributionList);
        entityManager.persist(emailDistributionList2);
        transaction.commit();

        System.out.println(employee.getPaySlips());

    }
}
