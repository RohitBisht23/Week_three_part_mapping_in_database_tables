package com.WeekThreeMappingInTables.demo.Controllers;


import com.WeekThreeMappingInTables.demo.entities.ProjectEntity;
import com.WeekThreeMappingInTables.demo.services.ProjectServices;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="project")
public class ProjectController {

    private  final ProjectServices projectServices;


    public ProjectController(ProjectServices projectServices) {
        this.projectServices = projectServices;
    }

    @GetMapping
    public ProjectEntity getProjectById(@RequestParam Long id) {
        return projectServices.findProjectById(id);
    }

    @PostMapping
    public ProjectEntity createNewProject(@RequestBody ProjectEntity projectEntity) {
        return projectServices.createNewProject(projectEntity);
    }

    @PostMapping(path="/{projectId}/assignEmployeeToProject/{employeeId}")
    public ProjectEntity assignEmployeeToProject(@PathVariable Long employeeId, @PathVariable Long projectId) {
        return projectServices.assignEmployeeToProject(employeeId, projectId);
    }
}
