package com.app.CRM.service;

import com.app.CRM.Enums.EmployeeStatus;
import com.app.CRM.Enums.Role;
import com.app.CRM.dto.EmployeeRequestDto;
import com.app.CRM.dto.EmployeeResponseDto;
import com.app.CRM.exception.DepartmentNotFoundException;
import com.app.CRM.exception.UserNotFoundException;
import com.app.CRM.model.AppUser;
import com.app.CRM.model.Department;
import com.app.CRM.model.Employee;
import com.app.CRM.model.Project;
import com.app.CRM.repository.AppUserRepo;
import com.app.CRM.repository.DepartmentRepo;
import com.app.CRM.repository.EmployeeRepo;
import com.app.CRM.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private AppUserRepo appUserRepo;
    @Autowired
    private ProjectRepo projectRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Employee createEmployee(EmployeeRequestDto employee){
        if(employeeRepo.existsByEmail(employee.getEmail())){
            throw new RuntimeException(" Email Already Exists");
        }
        AppUser user = new AppUser();
        user.setUsername(employee.getUsername());
        user.setPassword(passwordEncoder.encode(employee.getPassword()));
        user.setRole(Role.EMPLOYEE);
        appUserRepo.save(user);
        Employee emp = new Employee();
        emp.setName(employee.getName());
        emp.setEmail(employee.getEmail());
        emp.setPhone(employee.getPhone());
        emp.setSalary(employee.getSalary());
        emp.setDesignation(employee.getDesignation());
        emp.setJoiningDate(LocalDate.now());
        emp.setStatus(EmployeeStatus.ACTIVE);
        emp.setUser(user);
        return employeeRepo.save(emp);
    }
    private EmployeeResponseDto mapToResponseDTO(Employee employee) {

        EmployeeResponseDto dto = new EmployeeResponseDto();

        dto.setEid(employee.getEid());
        dto.setName(employee.getName());
        dto.setEmail(employee.getEmail());
        dto.setPhone(employee.getPhone());
        dto.setDesignation(employee.getDesignation());
        dto.setJoiningDate(employee.getJoiningDate());
        dto.setSalary(employee.getSalary());
        dto.setStatus(employee.getStatus());

        // Department
        if (employee.getDepartment() != null) {
            dto.setDepartmentId(employee.getDepartment().getId());
            dto.setDepartmentName(employee.getDepartment().getName());
        }

        // User
        if (employee.getUser() != null) {
            dto.setUserId(employee.getUser().getId());
            dto.setUsername(employee.getUser().getUsername());
        }

        // Manager
        if (employee.getManager() != null) {
            dto.setManagerId(employee.getManager().getEid());
            dto.setManagerName(employee.getManager().getName());
        }

        // Team Members
        if (employee.getTeamMembers() != null && !employee.getTeamMembers().isEmpty()) {
            dto.setTeamMemberIds(
                    employee.getTeamMembers()
                            .stream()
                            .map(Employee::getEid)
                            .toList()
            );
        }

        return dto;
    }

    public List<EmployeeResponseDto> getAllEmployee(){
        List<Employee> employees = employeeRepo.findAll();

        return employees.stream()
                .map(this::mapToResponseDTO)
                .toList();
    }

    public String assignEmployee( Long projectId, Long employeeId, boolean isManager){
        Project project = projectRepo.findById(projectId)
                .orElseThrow(()->new RuntimeException("project not found"));
        Employee employee = employeeRepo.findById(employeeId)
                .orElseThrow(()->new RuntimeException("Employee not found"));
        employee.getProjects().add(project);

        if(isManager){
            project.setManager(employee);
        }
        employeeRepo.save(employee);
        return " employees assigned succesfully";
    }

}
