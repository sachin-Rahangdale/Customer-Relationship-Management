package com.app.CRM.dto;
import com.app.CRM.Enums.EmployeeStatus;
import com.app.CRM.model.Department;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class EmployeeResponseDto {
    private Long eid;
    private String name;
    private String email;
    private String phone;
    private String designation;

    private LocalDate joiningDate;
    private double salary;

    private EmployeeStatus status;

    private Long departmentId;
    private String departmentName;

    private Long userId;
    private String username;

    private Long managerId;
    private String managerName;

    private List<Long> teamMemberIds;
}
