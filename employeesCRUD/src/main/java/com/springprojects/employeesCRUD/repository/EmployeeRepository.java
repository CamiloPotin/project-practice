package com.springprojects.employeesCRUD.repository;

import com.springprojects.employeesCRUD.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
