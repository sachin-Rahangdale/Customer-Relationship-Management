package com.app.CRM.service;

import com.app.CRM.Enums.ProjectStatus;
import com.app.CRM.dto.ProjectCreateDto;
import com.app.CRM.model.Employee;
import com.app.CRM.model.Project;
import com.app.CRM.repository.EmployeeRepo;
import com.app.CRM.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepo projectRepo;
    @Autowired
    private EmployeeRepo employeeRepo;

    public Project addProject( ProjectCreateDto dto){
        if(projectRepo.existsByName(dto.getName())){
            throw new RuntimeException("Project already existy by that name");
        }
        Project project = new Project();
        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setStartDate(dto.getStartDate());
        project.setEndDate(dto.getEndDate());
        project.setProjectStatus(ProjectStatus.NOT_STARTED);
//        Employee manager = employeeRepo.findById(dto.getManagerId())
//                .orElseThrow();
//        project.setManager(manager);
//
//        Set<Employee> members =
//                employeeRepo.findAllById(dto.getTeamMemberIds())
//                        .stream().collect(Collectors.toSet());
//        project.setTeamMember(members);

        return projectRepo.save(project);
    }

    public Project updateProject;


}
