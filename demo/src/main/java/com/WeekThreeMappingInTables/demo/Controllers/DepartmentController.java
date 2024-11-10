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

    @GetMapping(path="/{departmentId}")
    public DepartmentEntity getDepartmentById(@RequestParam Long id) {
        return departmentServices.getDepartmentById(id);
    }

    @PostMapping
    public  DepartmentEntity createNewDepartment(@RequestBody DepartmentEntity departmentEntity) {
        return departmentServices.createNewDepartment(departmentEntity);
    }
}
