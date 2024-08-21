package com.employee_payroll_mgmt.repository;

import com.employee_payroll_mgmt.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
