package com.enesderin.employeemanagmentsystem.controller;

import com.enesderin.employeemanagmentsystem.business.abstracts.EmployeeService;
import com.enesderin.employeemanagmentsystem.dtos.requests.CreateEmployeeRequest;
import com.enesderin.employeemanagmentsystem.dtos.responses.GetAllEmployees;
import com.enesderin.employeemanagmentsystem.dtos.responses.GetOneEmployeeResponse;
import com.enesderin.employeemanagmentsystem.entities.Employee;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    @GetMapping
    public List<GetAllEmployees> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public GetOneEmployeeResponse createEmployee(@RequestBody CreateEmployeeRequest createEmployeeRequest) {
        return employeeService.CreateEmployee(createEmployeeRequest);
    }

    @GetMapping("/{id}")
    public Optional<GetOneEmployeeResponse> getOneById(@PathVariable int id)  {
        return employeeService.getOneById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.DeleteEmployee(id);
    }
}
