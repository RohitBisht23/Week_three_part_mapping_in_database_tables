package com.WeekThreeMappingInTables.demo.services;

import com.WeekThreeMappingInTables.demo.entities.EmployeeEntity;
import com.WeekThreeMappingInTables.demo.entities.ProjectEntity;
import com.WeekThreeMappingInTables.demo.repositories.EmployeeRepository;
import com.WeekThreeMappingInTables.demo.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectServices {

    private  final ProjectRepository projectRepository;
    private final EmployeeRepository employeeRepository;

    public ProjectServices(ProjectRepository projectRepository, EmployeeRepository employeeRepository) {
        this.projectRepository = projectRepository;
        this.employeeRepository = employeeRepository;
    }

    public ProjectEntity findProjectById(Long projectId) {
        return projectRepository.findById(projectId).orElse(null);
    }

    public ProjectEntity createNewProject(ProjectEntity projectEntity) {
        return projectRepository.save(projectEntity);
    }

    public ProjectEntity assignEmployeeToProject(Long employeeId, Long projectId) {
        Optional<ProjectEntity> projectEntity = projectRepository.findById(projectId);
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeId);

        return projectEntity.flatMap(project ->
                employeeEntity.map(employeeEntity1 -> {
                    project.getProject_memebers().add(employeeEntity1);
                    projectRepository.save(project);
                    return project;
                })).orElse(null);
    }
}
