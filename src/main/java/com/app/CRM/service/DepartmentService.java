package com.app.CRM.service;

import com.app.CRM.dto.DepartmentRequestDto;
import com.app.CRM.dto.DepartmentResponseDto;
import com.app.CRM.model.Department;
import com.app.CRM.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepo departmentRepo;

//    public void mapToReponse(Department department){
//        DepartmentResponseDto dept = new DepartmentResponseDto();
//        dept.setId(department.getId());
//        sept.
//
//    }

    public String addDepartment(DepartmentRequestDto departmentRequestDto){
        Department department = new Department();
        department.setName(departmentRequestDto.getName());
        department.setDescription(departmentRequestDto.getDescription());
        department.setCreatedBy(departmentRequestDto.getCreatedBy());
        department.setCreatedAt(LocalDateTime.now());
        departmentRepo.save(department);
        return" department added succesfully";
    }

    public List<Department> getAllDepartment(){
        return departmentRepo.findAll();
    }

}
