package com.employee_payroll_mgmt.service;

import com.employee_payroll_mgmt.entity.Employee;
import com.employee_payroll_mgmt.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        calculateSalary(employee);
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        employee.setName(updatedEmployee.getName());
        employee.setAge(updatedEmployee.getAge());
        employee.setDesignation(updatedEmployee.getDesignation());
        employee.setRating(updatedEmployee.getRating());
        calculateSalary(employee);
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    private void calculateSalary(Employee employee) {
        int age = employee.getAge();
        int rating = employee.getRating();
        double salary = 0.0;

        if (age >= 21 && age <= 26) {
            salary = 40000 - (rating - 1) * 0.05 * 40000;
            employee.setDesignation("Software Developer");
        } else if (age > 26 && age <= 35) {
            // Implement other rules as described
            // Set designation to Senior Developer, Tech Lead, or Architect
            // and calculate salary accordingly
        } else if (age > 35 && age <= 60) {
            // Implement other rules as described
            // Set designation to Manager, Senior Manager, or Delivery Head
            // and calculate salary accordingly
        }

        employee.setSalary(salary);
    }
}
