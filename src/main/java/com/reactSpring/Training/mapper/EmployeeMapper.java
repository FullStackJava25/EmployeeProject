package com.reactSpring.Training.mapper;

import com.reactSpring.Training.dto.EmployeeDto;
import com.reactSpring.Training.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee e)
    {
        return new EmployeeDto(e.getId(),e.getFirstName(),e.getLastName(),e.getEmail());
    }

    public static Employee mapToEmployee(EmployeeDto ed) {
        return new Employee(ed.getID(),ed.getFirstName(),ed.getSecondName(),ed.getEmail());
    }
}
