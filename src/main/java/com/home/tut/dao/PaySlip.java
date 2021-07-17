package com.home.tut.dao;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class PaySlip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDateTime cycleStartDate;
    private LocalDateTime cycleEndDate;
    private int salary;
    @ManyToOne
    private Employee employee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCycleStartDate() {
        return cycleStartDate;
    }

    public void setCycleStartDate(LocalDateTime cycleStartDate) {
        this.cycleStartDate = cycleStartDate;
    }

    public LocalDateTime getCycleEndDate() {
        return cycleEndDate;
    }

    public void setCycleEndDate(LocalDateTime cycleEndDate) {
        this.cycleEndDate = cycleEndDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "PaySlip{" +
                "id=" + id +
                ", cycleStartDate=" + cycleStartDate +
                ", cycleEndDate=" + cycleEndDate +
                ", salary=" + salary +
                '}';
    }
}
