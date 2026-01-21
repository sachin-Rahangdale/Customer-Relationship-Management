package com.app.CRM.dto;

import com.app.CRM.Enums.EmployeeStatus;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class EmployeeRequestDto {
    private String name;
    private String email;
    private String phone;
    private String designation;
    private LocalDate joiningDate;
    private double salary;
    private EmployeeStatus status;
    private String username;
    private String password;

}
