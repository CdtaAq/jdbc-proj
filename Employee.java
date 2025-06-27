package com.synergisticit.domain;

public class Employee {
    private Integer empId;
    private String name;
    private String designation;
    private Double salary;

    public Employee() {}

    public Employee(Integer empId, String name, String designation, Double salary) {
        this.empId = empId;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    public Employee(String name, String designation, Double salary) {
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    // Getters and Setters
    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return empId + " - " + name + " - " + designation + " - $" + salary;
    }
}
