package com.app.CRM.controller;

import com.app.CRM.Enums.ProjectStatus;
import com.app.CRM.dto.ProjectCreateDto;
import com.app.CRM.model.Project;
import com.app.CRM.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
public class ProjectController {
   @Autowired
   private ProjectService projectService;

    @PostMapping
    public ResponseEntity<Project> create(@RequestBody ProjectCreateDto dto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(projectService.addProject(dto));
    }
}
