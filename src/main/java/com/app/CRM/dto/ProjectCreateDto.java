package com.app.CRM.dto;
import com.app.CRM.Enums.ProjectStatus;
import lombok.Data;
import java.time.LocalDate;
import java.util.Set;

@Data
public class ProjectCreateDto {

    private String name;
    private String description;

    private LocalDate startDate;
    private LocalDate endDate;

    private ProjectStatus projectStatus;

//    private Long managerId;          // Employee ID only
//    private Set<Long> teamMemberIds;

}
