package com.app.CRM.model;
import com.app.CRM.Enums.ProjectStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    private LocalDate startDate;
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    private ProjectStatus projectStatus;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;

    @ManyToMany(mappedBy = "projects")
    @JsonIgnore
    private Set<Employee> teamMember= new HashSet<>();



}