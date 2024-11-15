package com.WeekThreeMappingInTables.demo.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.engine.internal.Cascade;

import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToOne(mappedBy = "manager")
    @JsonIgnore
    private DepartmentEntity managedDepartment;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "worker_department_Id", referencedColumnName = "id")
    //@JsonBackReference // Prevent recursion
    @JsonIgnore
    private DepartmentEntity workerDepartment;

//    @ManyToMany(cascade = CascadeType.ALL)
//    private List<ProjectEntity> projects;


    @ManyToMany
    @JoinTable(
            name = "freelance_Department_mapping",
            joinColumns = @JoinColumn(name = "freelance_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id")
    )
    @JsonIgnore
    private Set<DepartmentEntity> freelanceDepartment;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeEntity that = (EmployeeEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}