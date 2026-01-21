package com.app.CRM.dto;

import com.app.CRM.Enums.EmployeeStatus;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class EmployeeUpdateRequestDto {
    private Long eid; // required for update
    private String name;
    private String email;
    private String phone;
    private String designation;
    private Double salary;   // wrapper → allow partial update
    private EmployeeStatus status;
    private Long departmentId;
    private Long userId;
    private Long managerId;
    private List<Long> teamMemberIds;
}
