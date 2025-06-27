package com.synergisticit.runner;

import com.synergisticit.dao.EmployeeDAO;
import com.synergisticit.domain.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeRunner implements CommandLineRunner {

    private final EmployeeDAO employeeDAO;

    public EmployeeRunner(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=== Inserting Employees ===");
        employeeDAO.save(new Employee("Alice", "Manager", 75000.0));
        employeeDAO.save(new Employee("Bob", "Engineer", 65000.0));

        System.out.println("\n=== All Employees ===");
        List<Employee> all = employeeDAO.findAll();
        all.forEach(System.out::println);

        System.out.println("\n=== Update Bob to Senior Engineer ===");
        Employee bob = all.get(1);
        bob.setDesignation("Senior Engineer");
        bob.setSalary(72000.0);
        employeeDAO.update(bob);

        System.out.println("\n=== Find Bob by ID ===");
        System.out.println(employeeDAO.findById(bob.getEmpId()));

        System.out.println("\n=== Delete Alice ===");
        employeeDAO.deleteById(all.get(0).getEmpId());

        System.out.println("\n=== Final Employee List ===");
        employeeDAO.findAll().forEach(System.out::println);
    }
}
