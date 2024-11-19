package com.employeedatabasemanagementsystem.EmployeeDatabaseManagementSystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request_category {

    @Id
    private  int id;
    private  String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


}
