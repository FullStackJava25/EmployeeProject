package com.reactSpring.Training.service;

import com.reactSpring.Training.dto.EmployeeDto;
import com.reactSpring.Training.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeServiceInterface {

    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeId);
    // 🔹 Get All Employees
    List<EmployeeDto> getAllEmployees();

    // 🔹 Update Employee
    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployeeDto);

    // 🔹 Delete Employee
    void deleteEmployee(Long employeeId);

}
