package com.employeedatabasemanagementsystem.EmployeeDatabaseManagementSystem.service;

import com.employeedatabasemanagementsystem.EmployeeDatabaseManagementSystem.entity.Time_Off_Request;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TimeOffService {


    public boolean canRequestTimeOff(List<Time_Off_Request> requests, Time_Off_Request newRequest, int workRemotelyCategoryId) {
        for (Time_Off_Request request : requests) {
            boolean overlap = newRequest.getStartDate().isBefore(request.getEndDate()) && newRequest.getEndDate().isAfter(request.getStartDate());
            boolean bothNonRemote = request.getRequestCategoryId() != workRemotelyCategoryId && newRequest.getRequestCategoryId() != workRemotelyCategoryId;

            if (overlap && bothNonRemote) {
                return false;
            }
        }
        return true;
    }
}
