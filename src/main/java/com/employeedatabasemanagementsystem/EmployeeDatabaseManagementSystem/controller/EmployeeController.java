package com.employeedatabasemanagementsystem.EmployeeDatabaseManagementSystem.controller;

import com.employeedatabasemanagementsystem.EmployeeDatabaseManagementSystem.entity.Employee;
import com.employeedatabasemanagementsystem.EmployeeDatabaseManagementSystem.exception.CustomEmployeeException;
import com.employeedatabasemanagementsystem.EmployeeDatabaseManagementSystem.service.EmployeeDatabase;
import com.employeedatabasemanagementsystem.EmployeeDatabaseManagementSystem.util.TimezoneUtil;
import jakarta.validation.Valid;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employeeDatabaseManagementSystem")
public class EmployeeController {

    @Autowired
    private EmployeeDatabase employeeDatabase;


    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
    {
        if(employee == null)
        {

            throw new CustomEmployeeException(HttpStatus.BAD_REQUEST, "Employee can't be null");
        }

        ZonedDateTime serverTime = TimezoneUtil.getCurrentRemoteServerTime();
        employee.setCreatedAt(serverTime.toLocalDateTime());
        employee.setModifiedAt(serverTime.toLocalDateTime());
        return ResponseEntity.ok(employeeDatabase.add_employee(employee));
    }

    @GetMapping("/employee/{uuid}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable UUID uuid )
    {
        if(uuid == null)
        {
            throw new CustomEmployeeException(HttpStatus.BAD_REQUEST, "Please provide a valid UUID");
        }

        Employee employee = employeeDatabase.get_employee(uuid);
        if (employee != null) {
            employee.setCreatedAt(TimezoneUtil.convertToLocalTime(
                    TimezoneUtil.convertToRemoteServerTime(employee.getCreatedAt())));
            employee.setModifiedAt(TimezoneUtil.convertToLocalTime(
                    TimezoneUtil.convertToRemoteServerTime(employee.getModifiedAt())));
        }

        return ResponseEntity.ok(employeeDatabase.get_employee(uuid));
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployee()
    {

        List<Employee> employees = employeeDatabase.get_all().stream()
                .peek(emp -> {
                    emp.setCreatedAt(TimezoneUtil.convertToLocalTime(
                            TimezoneUtil.convertToRemoteServerTime(emp.getCreatedAt())));
                    emp.setModifiedAt(TimezoneUtil.convertToLocalTime(
                            TimezoneUtil.convertToRemoteServerTime(emp.getModifiedAt())));
                })
                .collect(Collectors.toList());


       return ResponseEntity.ok(employeeDatabase.get_all());
    }

    @GetMapping("/employeesInString")
    public ResponseEntity<String> getAllEmployeeToString()
    {

        return ResponseEntity.ok(employeeDatabase.get_all().toString());
    }

    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable UUID id, @RequestBody Employee employee)
    {
        if(id== null || employee == null)
        {
            throw new CustomEmployeeException(HttpStatus.INTERNAL_SERVER_ERROR, "Please provide a valid UUID or employee can't be null");
        }
        return ResponseEntity.ok(employeeDatabase.update_employee(id, employee));
    }






}
