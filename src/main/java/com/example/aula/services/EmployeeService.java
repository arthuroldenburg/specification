package com.example.aula.services;

import com.example.aula.models.Employee;
import com.example.aula.models.Order;
import com.example.aula.repositories.EmployeeRepository;
import com.example.aula.repositories.OrderRepository;
import com.example.aula.specifications.EmployeeSpecification;
import com.example.aula.specifications.OrderSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmplyees(String firstName, String departament, Long minSalary, LocalDate hiredAfter, LocalDate hiredBefor, Boolean active) {
        Specification<Employee> spec = Specification
                .where(EmployeeSpecification.hasFirstName(firstName))
                .and(EmployeeSpecification.hasDepartament(departament))
                .and(EmployeeSpecification.hasMinSalary(minSalary))
                .and(EmployeeSpecification.hasHiredBetween(hiredAfter, hiredBefor))
                .and(EmployeeSpecification.hasActive(active));
        return employeeRepository.findAll(spec);
    }

}
