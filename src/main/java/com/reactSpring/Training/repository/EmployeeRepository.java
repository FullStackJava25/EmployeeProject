package com.reactSpring.Training.repository;

import com.reactSpring.Training.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
