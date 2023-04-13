package com.uob.hrSystem.Repositories.Employee;

import com.uob.hrSystem.Models.Accounts.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findByUsername(String username);
}
