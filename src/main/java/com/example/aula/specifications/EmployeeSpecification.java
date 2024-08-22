package com.example.aula.specifications;

import com.example.aula.models.Employee;
import com.example.aula.models.Order;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class EmployeeSpecification {

    public static Specification<Employee> hasFirstName(String firstName) {
        return (((root, query, criteriaBuilder) ->
                firstName == null ?
                        null :
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("firstName")), "%"+firstName.toLowerCase()+"%")));
    }

    public static Specification<Employee> hasDepartament(String departament) {
        return (((root, query, criteriaBuilder) ->
                departament == null ?
                        null :
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("department")), "%"+departament.toLowerCase()+"%")));
    }

    public static Specification<Employee> hasMinSalary(Long minSalary) {
        return (((root, query, criteriaBuilder) ->
                minSalary == null ?
                        null :
                        criteriaBuilder.greaterThanOrEqualTo(root.get("minSalary"), minSalary)));
    }

    public static Specification<Employee> hasHiredBetween(LocalDate hiredAfter, LocalDate hiredBefor){
        return ((root, query, criteriaBuilder) ->  {
            if(hiredAfter!=null && hiredBefor!=null) return criteriaBuilder.between(root.get("hireDate"), hiredAfter, hiredBefor);
            else if (hiredAfter!=null) return criteriaBuilder.greaterThanOrEqualTo(root.get("hireDate"), hiredAfter);
            else if (hiredBefor!=null) return criteriaBuilder.lessThanOrEqualTo(root.get("hireDate"), hiredBefor);
            return null;
        });
    }

    public static Specification<Employee> hasActive(Boolean active) {
        return (((root, query, criteriaBuilder) ->
                active == null ?
                        null :
                        criteriaBuilder.equal(root.get("active"), active)));
    }
}
