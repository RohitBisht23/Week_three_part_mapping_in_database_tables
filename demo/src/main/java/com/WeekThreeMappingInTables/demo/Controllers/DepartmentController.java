package com.WeekThreeMappingInTables.demo.Controllers;

import com.WeekThreeMappingInTables.demo.entities.DepartmentEntity;
import com.WeekThreeMappingInTables.demo.services.DepartmentServices;
import lombok.Builder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="department")
@Builder
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

    @PutMapping(path="/{departmentId}/assignWorkerToDepartment/{employeeId}")
    public DepartmentEntity assignWorkerToDepartment(@PathVariable Long departmentId, @PathVariable Long employeeId) {
        return departmentServices.assignWorkerToDepartment(departmentId, employeeId);
    }

    @PutMapping(path="/{departmentId}/freelancer/{freelancerId}")
    public DepartmentEntity assignFreelancerToDepartment(@PathVariable Long departmentId, @PathVariable Long freelancerId) {
        return departmentServices.assignFreelancerToDepartment(departmentId, freelancerId);
    }
}
