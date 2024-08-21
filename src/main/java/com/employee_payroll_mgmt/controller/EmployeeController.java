package com.employee_payroll_mgmt.controller;

import com.employee_payroll_mgmt.dto.GeneralResponse;
import com.employee_payroll_mgmt.entity.Employee;
import com.employee_payroll_mgmt.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<GeneralResponse> getAllEmployees() {
        return ResponseEntity.status(HttpStatus.OK).body(new GeneralResponse(true, "Retrieve Employees data Successfully",
                employeeService.getAllEmployees()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeneralResponse> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(new GeneralResponse(true, "Retrieve Employee data Successfully",
                employeeService.getEmployeeById(id)));
    }

    @PostMapping
    public ResponseEntity<GeneralResponse> addEmployee(@RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new GeneralResponse(true, "Employee Saved Successfully",
                employeeService.addEmployee(employee)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeneralResponse> updateEmployee(@RequestBody Employee employee, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(new GeneralResponse(true, "Employee Update Successfully",
                employeeService.updateEmployee(id, employee)));
    }
  }
