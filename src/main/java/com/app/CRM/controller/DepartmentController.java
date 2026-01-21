package com.app.CRM.controller;

import com.app.CRM.dto.DepartmentRequestDto;
import com.app.CRM.model.Department;
import com.app.CRM.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/add")
    public ResponseEntity<String> createDepartment(@RequestBody DepartmentRequestDto departmentRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.addDepartment(departmentRequestDto));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Department>> getAll(){
        return ResponseEntity.ok(departmentService.getAllDepartment());
    }


}
