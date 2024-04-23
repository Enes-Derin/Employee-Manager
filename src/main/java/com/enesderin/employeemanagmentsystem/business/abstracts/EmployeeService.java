package com.enesderin.employeemanagmentsystem.business.abstracts;

import com.enesderin.employeemanagmentsystem.dtos.requests.CreateEmployeeRequest;
import com.enesderin.employeemanagmentsystem.dtos.requests.UpdateEmployeeRequest;
import com.enesderin.employeemanagmentsystem.dtos.responses.GetAllEmployees;
import com.enesderin.employeemanagmentsystem.dtos.responses.GetOneEmployeeResponse;
import com.enesderin.employeemanagmentsystem.dtos.responses.UpdatedEmployeeResponse;


import java.util.List;
import java.util.Optional;


public interface EmployeeService {
    List<GetAllEmployees> getAllEmployees();
    Optional<GetOneEmployeeResponse> getOneById(int id) ;
    GetOneEmployeeResponse CreateEmployee(CreateEmployeeRequest createEmployeeRequest);
    UpdatedEmployeeResponse UpdateEmployee(int id, UpdateEmployeeRequest updateEmployeeRequest);

    void DeleteEmployee(int id);



}
