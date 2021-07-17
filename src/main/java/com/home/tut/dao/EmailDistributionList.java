package com.home.tut.dao;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class EmailDistributionList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String dlName;
    @ManyToMany(mappedBy = "emailDistributionLists")
    private List<Employee> employees = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDlName() {
        return dlName;
    }

    public void setDlName(String dlName) {
        this.dlName = dlName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    private void addEmployee(Employee employee) {
        this.employees.add(employee);
    }
}
