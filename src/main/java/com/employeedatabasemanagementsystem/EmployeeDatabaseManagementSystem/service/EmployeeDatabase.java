package com.employeedatabasemanagementsystem.EmployeeDatabaseManagementSystem.service;


import com.employeedatabasemanagementsystem.EmployeeDatabaseManagementSystem.entity.Employee;
import com.employeedatabasemanagementsystem.EmployeeDatabaseManagementSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeDatabase {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee add_employee(Employee employee)
    {
           return  employeeRepository.save(employee);

    }
    public Employee get_employee(UUID id)
    {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee update_employee(UUID id, Employee updatedEmployee)
    {
        Employee existingEmployee = employeeRepository.findById(id).orElse(null);

        existingEmployee.setName(updatedEmployee.getName());
        existingEmployee.setEmail(updatedEmployee.getEmail());
        existingEmployee.setPosition(updatedEmployee.getPosition());
        existingEmployee.setSalary(updatedEmployee.getSalary());
        existingEmployee.setCreatedAt(updatedEmployee.getCreatedAt());
        existingEmployee.setModifiedAt(updatedEmployee.getModifiedAt());


        return employeeRepository.save(existingEmployee);

    }
    public List<Employee> get_all()
    {
        return employeeRepository.findAll();
    }
    public String __str__()
    {
        return employeeRepository.findAll().toString();
    }





}
