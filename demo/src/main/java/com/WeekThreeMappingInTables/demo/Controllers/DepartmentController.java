package com.WeekThreeMappingInTables.demo.Controllers;

import com.WeekThreeMappingInTables.demo.entities.DepartmentEntity;
import com.WeekThreeMappingInTables.demo.services.DepartmentServices;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="department")
public class DepartmentController {

    private final DepartmentServices departmentServices;

    public DepartmentController(DepartmentServices departmentServices) {
        this.departmentServices = departmentServices;
    }

    @GetMapping
    public DepartmentEntity getDepartmentById(@RequestParam Long id) {
        return departmentServices.getDepartmentById(id);
    }

    @PostMapping
    public  DepartmentEntity createNewDepartment(@RequestBody DepartmentEntity departmentEntity) {
        return departmentServices.createNewDepartment(departmentEntity);
    }


    @PutMapping(path="/{departmentId}/manager/{employeeId}")
    public DepartmentEntity assignManagerToDepartment(@PathVariable Long departmentId, @PathVariable Long employeeId) {
        return departmentServices.assignManagerToDepartment(departmentId, employeeId);
    }

    @GetMapping(path="/assignDepartmentOfManager/{employeeId}")
    public DepartmentEntity getAssignDepartmentOfManager(@PathVariable Long employeeId) {
        return departmentServices.getAssignDepartmentOfManager(employeeId);
    }
}
