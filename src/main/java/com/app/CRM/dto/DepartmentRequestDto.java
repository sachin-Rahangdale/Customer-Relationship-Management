package com.app.CRM.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class DepartmentRequestDto {

    private String name;
    private String description;
    private Long createdBy;

}
