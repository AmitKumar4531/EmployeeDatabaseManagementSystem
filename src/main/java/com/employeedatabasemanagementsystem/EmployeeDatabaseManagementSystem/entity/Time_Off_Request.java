package com.employeedatabasemanagementsystem.EmployeeDatabaseManagementSystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Time_Off_Request {

    @Id
    private  int id;
    private  int requestCategoryId;
    private UUID employeeId;
    private  LocalDate startDate;
    private  LocalDate endDate;


    public int getId() {
        return id;
    }

    public int getRequestCategoryId() {
        return requestCategoryId;
    }

    public UUID getEmployeeId() {
        return employeeId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }


}
