package com.WeekThreeMappingInTables.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.Set;

@Entity
//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private  String title;

    @OneToOne
    @JoinColumn(name="department_manager")
    private EmployeeEntity manager;

    @OneToMany(mappedBy = "workerDepartment", fetch = FetchType.LAZY)
    //@JsonManagedReference // This will manage the forward side of the relationship
    //@JsonIgnore
    private Set<EmployeeEntity> workers;

    @ManyToMany(mappedBy = "freelanceDepartment")
    private Set<EmployeeEntity> freelancers;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentEntity that = (DepartmentEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }
}
