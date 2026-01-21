package com.app.CRM.model;
import com.app.CRM.Enums.EmployeeStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eid;
    private String name;
    private String email;
    private String phone;
    private String designation;

    private LocalDate joiningDate;
    private double salary;

    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;

    @OneToMany
    @JoinColumn(name = "manager")
    private List<Employee> teamMembers;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;


    @OneToOne
    @JoinColumn(name = "user_id")
    private AppUser user;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(mappedBy = "manager")
    @JsonIgnore
    private List<Project> projectList;

    @ManyToMany
    @JoinTable(name = "employees_project",joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id"))
    private Set<Project> projects = new HashSet<>();
}