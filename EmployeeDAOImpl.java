package com.synergisticit.dao;

import com.synergisticit.domain.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final JdbcTemplate jdbcTemplate;

    public EmployeeDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Employee> rowMapper = (rs, rowNum) -> new Employee(
            rs.getInt("empId"),
            rs.getString("name"),
            rs.getString("designation"),
            rs.getDouble("salary")
    );

    @Override
    public void save(Employee emp) {
        String sql = "INSERT INTO employee (name, designation, salary) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, emp.getName(), emp.getDesignation(), emp.getSalary());
    }

    @Override
    public void update(Employee emp) {
        String sql = "UPDATE employee SET name = ?, designation = ?, salary = ? WHERE empId = ?";
        jdbcTemplate.update(sql, emp.getName(), emp.getDesignation(), emp.getSalary(), emp.getEmpId());
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM employee WHERE empId = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Employee findById(int id) {
        String sql = "SELECT * FROM employee WHERE empId = ?";
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    @Override
    public List<Employee> findAll() {
        String sql = "SELECT * FROM employee";
        return jdbcTemplate.query(sql, rowMapper);
    }
}
