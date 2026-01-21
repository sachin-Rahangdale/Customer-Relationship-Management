package com.app.CRM.repository;

import com.app.CRM.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    boolean existsByEmail(String email);
}
