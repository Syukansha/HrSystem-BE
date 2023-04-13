package com.uob.hrSystem.Repositories.Employee;

import com.uob.hrSystem.Models.Employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
