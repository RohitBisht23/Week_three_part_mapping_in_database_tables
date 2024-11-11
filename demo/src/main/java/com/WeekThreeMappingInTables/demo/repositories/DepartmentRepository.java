package com.WeekThreeMappingInTables.demo.repositories;

import com.WeekThreeMappingInTables.demo.entities.DepartmentEntity;
import com.WeekThreeMappingInTables.demo.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
    DepartmentEntity findByManager(EmployeeEntity employeeEntity);
}
