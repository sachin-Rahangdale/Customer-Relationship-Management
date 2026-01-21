package com.app.CRM.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
//havent used it now
@Data
public class DepartmentResponseDto {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private Long createdBy;
}
