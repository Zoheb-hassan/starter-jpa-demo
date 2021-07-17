package com.home.tut.dao;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "EMPLOYEE_DATA")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;
    @Transient
    private String nonPersistedValue;
    private LocalDateTime dateOfBirth;
    @OneToMany(mappedBy = "employee")
    private List<PaySlip> paySlips;

    @OneToOne
    private AccessCard accessCard;

    @ManyToMany
    @JoinTable( name = "employee_dl_mapping",
            joinColumns = @JoinColumn(name = "emp_id"),
            inverseJoinColumns = @JoinColumn(name = "dl_id")
                )
    private List<EmailDistributionList> emailDistributionLists = new ArrayList<>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public String getNonPersistedValue() {
        return nonPersistedValue;
    }

    public void setNonPersistedValue(String nonPersistedValue) {
        this.nonPersistedValue = nonPersistedValue;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public AccessCard getAccessCard() {
        return accessCard;
    }

    public void setAccessCard(AccessCard accessCard) {
        this.accessCard = accessCard;
    }

    public List<PaySlip> getPaySlips() {
        return paySlips;
    }

    public void setPaySlips(List<PaySlip> paySlips) {
        this.paySlips = paySlips;
    }

    public List<EmailDistributionList> getEmailDistributionLists() {
        return emailDistributionLists;
    }

    public void setEmailDistributionLists(List<EmailDistributionList> emailDistributionLists) {
        this.emailDistributionLists = emailDistributionLists;
    }

    private void addMailDl(EmailDistributionList emailDistributionList) {
        this.emailDistributionLists.add(emailDistributionList);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employeeType=" + employeeType +
                ", nonPersistedValue='" + nonPersistedValue + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
