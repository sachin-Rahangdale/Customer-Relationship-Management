package com.app.CRM.model;

import com.app.CRM.Enums.EmployeeStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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
    private Long eId;

    private String name;
    private String email;
    private String phone;
    private String designation;
    private LocalDate joiningDate;
    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;
    private Long userId;
    private Long departmentId;
    private Long managerId;


}
