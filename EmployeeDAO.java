package com.synergisticit.dao;

import com.synergisticit.domain.Employee;

import java.util.List;

public interface EmployeeDAO {
    void save(Employee employee);
    void update(Employee employee);
    void deleteById(int id);
    Employee findById(int id);
    List<Employee> findAll();
}
