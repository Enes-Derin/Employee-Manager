package com.enesderin.employeemanagmentsystem.business.abstracts;

import com.enesderin.employeemanagmentsystem.dtos.requests.CreateEmployeeRequest;
import com.enesderin.employeemanagmentsystem.dtos.requests.UpdateEmployeeRequest;
import com.enesderin.employeemanagmentsystem.dtos.responses.GetAllEmployees;
import com.enesderin.employeemanagmentsystem.dtos.responses.GetOneEmployeeResponse;
import com.enesderin.employeemanagmentsystem.dtos.responses.UpdatedEmployeeResponse;

import java.util.List;

public interface EmployeeService {

    List<GetAllEmployees> getAllEmployees();

    GetOneEmployeeResponse getOneById(int id);

    GetOneEmployeeResponse CreateEmployee(CreateEmployeeRequest createEmployeeRequest);

    UpdatedEmployeeResponse updateEmployee(int id, UpdateEmployeeRequest updateEmployeeRequest);

    void DeleteEmployee(int id);

}
