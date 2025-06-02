package com.reactSpring.Training.service;
import com.reactSpring.Training.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.reactSpring.Training.dto.EmployeeDto;
import com.reactSpring.Training.entity.Employee;
import com.reactSpring.Training.mapper.EmployeeMapper;
import com.reactSpring.Training.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements EmployeeServiceInterface {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        logger.info("Creating an Employee ", employeeDto);
        Employee employee= EmployeeMapper.mapToEmployee(employeeDto);
        Employee createEmployee=employeeRepository.save(employee);
        logger.info("Returning EmployeeDTO: {}", employeeDto);
        return EmployeeMapper.mapToEmployeeDto(createEmployee);


    }

    public EmployeeDto getEmployeeById(Long employeeId) {
        logger.info("Fetching Employee with ID: {}", employeeId);

        Employee employee = employeeRepository.findById(employeeId).orElse(null);

        //   .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + employeeId));

        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);
        logger.info("Returning EmployeeDTO: {}", employeeDto);

        return employeeDto;
    }

    // 🔹 Get All Employees
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto).collect(Collectors.toList());
    }

    // 🔹 Update Employee
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployeeDto) {
        Employee existingEmployee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + employeeId));

        existingEmployee.setFirstName(updatedEmployeeDto.getFirstName());
        existingEmployee.setEmail(updatedEmployeeDto.getEmail());

        Employee updatedEmployee = employeeRepository.save(existingEmployee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
    }

    // 🔹 Delete Employee
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + employeeId));
        employeeRepository.delete(employee);
    }
}
