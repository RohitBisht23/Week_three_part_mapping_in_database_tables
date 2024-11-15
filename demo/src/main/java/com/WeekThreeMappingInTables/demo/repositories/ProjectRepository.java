package com.WeekThreeMappingInTables.demo.repositories;

import com.WeekThreeMappingInTables.demo.entities.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {
}
