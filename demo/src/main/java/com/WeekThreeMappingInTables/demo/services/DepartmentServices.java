package com.WeekThreeMappingInTables.demo.services;

import com.WeekThreeMappingInTables.demo.entities.DepartmentEntity;
import com.WeekThreeMappingInTables.demo.entities.EmployeeEntity;
import com.WeekThreeMappingInTables.demo.repositories.DepartmentRepository;
import com.WeekThreeMappingInTables.demo.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentServices {
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;


    public DepartmentServices(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    public DepartmentEntity createNewDepartment(DepartmentEntity department) {
        return departmentRepository.save(department);
    }

    public DepartmentEntity getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public DepartmentEntity assignManagerToDepartment(Long departmentId, Long employeeId) {
        Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(departmentId);
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeId);

        return departmentEntity.flatMap(department ->
                employeeEntity.map(employee -> {
                    department.setManager(employee);
                    //employee.setManagedDepartment(department);
                    return departmentRepository.save(department);
                })
        ).orElse(null);
    }

    public DepartmentEntity getAssignDepartmentOfManager(Long employeeId) {
        //First way
        //Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeId);

//        return employeeEntity.map(employee ->
//             employee.getManagedDepartment()
//        ).orElse(null);

        //Second way
        //return departmentRepository.findByManager(employeeEntity.get());

        /*Above are making two api call to database and to optimize it creating the
        employee entity by own using builder pattern ot lombork
         */
        EmployeeEntity employeeEntity = EmployeeEntity.builder().id(employeeId).build();
        return departmentRepository.findByManager(employeeEntity);
    }
}
