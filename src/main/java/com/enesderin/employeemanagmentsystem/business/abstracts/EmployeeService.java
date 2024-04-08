package com.enesderin.employeemanagmentsystem.business.abstracts;

import com.enesderin.employeemanagmentsystem.dtos.requests.CreateEmployeeRequest;
import com.enesderin.employeemanagmentsystem.dtos.responses.GetAllEmployees;
import com.enesderin.employeemanagmentsystem.dtos.responses.GetOneEmployeeResponse;
import com.enesderin.employeemanagmentsystem.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface EmployeeService {
    List<GetAllEmployees> getAllEmployees();
    Optional<GetOneEmployeeResponse> getOneByName(String name);
    GetOneEmployeeResponse CreateEmployee(CreateEmployeeRequest createEmployeeRequest);

    void DeleteEmployee(int id);



}
