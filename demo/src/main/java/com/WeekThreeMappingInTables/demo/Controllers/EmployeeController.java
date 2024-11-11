package com.WeekThreeMappingInTables.demo.Controllers;

import com.WeekThreeMappingInTables.demo.entities.EmployeeEntity;
import com.WeekThreeMappingInTables.demo.services.EmployeeServices;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="employee")
public class EmployeeController {


    private final EmployeeServices employeeServices;

    public EmployeeController(EmployeeServices employeeServices) {
        this.employeeServices = employeeServices;
    }

    @GetMapping
    public EmployeeEntity getEmployeeById(@RequestParam Long id) {
        return employeeServices.getEmployeeByID(id);
    }

    @PostMapping
    public EmployeeEntity getCreateNewEmployee(@RequestBody EmployeeEntity employeeEntity) {
        return employeeServices.getCreateNewEmployee(employeeEntity);
    }
}
