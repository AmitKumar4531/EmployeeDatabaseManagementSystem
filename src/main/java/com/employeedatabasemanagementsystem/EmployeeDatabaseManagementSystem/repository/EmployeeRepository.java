package com.employeedatabasemanagementsystem.EmployeeDatabaseManagementSystem.repository;

import com.employeedatabasemanagementsystem.EmployeeDatabaseManagementSystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {



}
