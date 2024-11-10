package com.WeekThreeMappingInTables.demo.services;

import com.WeekThreeMappingInTables.demo.entities.EmployeeEntity;
import com.WeekThreeMappingInTables.demo.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServices {

    private final EmployeeRepository employeeRepository;

    public EmployeeServices(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeEntity getCreateNewEmployee(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }

    public EmployeeEntity getEmployeeByID(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }
}
