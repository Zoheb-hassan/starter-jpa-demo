package com.home.tut.dao;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @OneToOne
    private AccessCard accessCard;


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

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employeeType=" + employeeType +
                '}';
    }
}
