package com.app.CRM.controller;

import com.app.CRM.dto.EmployeeRequestDto;
import com.app.CRM.dto.EmployeeResponseDto;
import com.app.CRM.model.Employee;
import com.app.CRM.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/emp")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<Employee>  createEmployee(@RequestBody EmployeeRequestDto emp){
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(emp));
    }
    @GetMapping
    public ResponseEntity<List<EmployeeResponseDto>> getAllEmployee() {
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }
    @PostMapping("/{projectId}/employees/{employeeId}")
    public ResponseEntity<String> assignEmployeeToProject(
            @PathVariable Long projectId,
            @PathVariable Long employeeId,
            @RequestParam(defaultValue = "false") boolean isManager) {

        String response = employeeService.assignEmployee(
                projectId,
                employeeId,
                isManager
        );

        return ResponseEntity.ok(response);
    }
}
