package com.example.aula.controllers;


import com.example.aula.models.Employee;
import com.example.aula.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String department,
            @RequestParam(required = false) Long minSalary,
            @RequestParam(required = false)LocalDate hireAfter,
            @RequestParam(required = false) LocalDate hireBefore,
            @RequestParam(required = false) Boolean active
            ) {
        return employeeService.getAllEmplyees(firstName, department, minSalary, hireAfter, hireBefore, active);
    }
}
