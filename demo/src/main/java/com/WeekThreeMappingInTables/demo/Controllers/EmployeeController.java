package com.WeekThreeMappingInTables.demo.Controllers;

import com.WeekThreeMappingInTables.demo.entities.EmployeeEntity;
import com.WeekThreeMappingInTables.demo.services.EmployeeServices;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="employee")
public class EmployeeController {


    private final EmployeeServices employeeServices;

    public EmployeeController(EmployeeServices employeeServices) {
        this.employeeServices = employeeServices;
    }

    public EmployeeEntity getEmployeeById(@RequestParam Long id) {
        return employeeServices.getEmployeeByID(id);
    }

    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity employeeEntity) {
        return employeeServices.getCreateNewEmployee(employeeEntity);
    }
}
