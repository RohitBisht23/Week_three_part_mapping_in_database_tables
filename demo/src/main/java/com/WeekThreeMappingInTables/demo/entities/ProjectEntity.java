package com.WeekThreeMappingInTables.demo.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "Assigned_employee_in_projects",
            joinColumns = @JoinColumn(name = "employee_projects_id"),
            inverseJoinColumns = @JoinColumn(name = "members_of_Projects_id")
    )
    private List<EmployeeEntity> project_memebers;
}
