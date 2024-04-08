package com.enesderin.employeemanagmentsystem.business.concretes;

import com.enesderin.employeemanagmentsystem.business.abstracts.EmployeeService;
import com.enesderin.employeemanagmentsystem.dtos.requests.CreateEmployeeRequest;
import com.enesderin.employeemanagmentsystem.dtos.responses.GetAllEmployees;
import com.enesderin.employeemanagmentsystem.dtos.responses.GetOneEmployeeResponse;
import com.enesderin.employeemanagmentsystem.entities.Employee;
import com.enesderin.employeemanagmentsystem.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public List<GetAllEmployees> getAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();
        List<GetAllEmployees> getAllEmployees = new ArrayList<>();


        for (Employee employee : employees) {
            GetAllEmployees getAllEmployee = new GetAllEmployees();
            getAllEmployee.setId(employee.getId());
            getAllEmployee.setName(employee.getName());
            getAllEmployee.setEmail(employee.getEmail());
            getAllEmployee.setJobTitle(employee.getJobTitle());
            getAllEmployee.setPhone(employee.getPhone());
            getAllEmployee.setImageUrl(employee.getImageUrl());
            getAllEmployee.setIsManager(employee.getIsManager());
            getAllEmployees.add(getAllEmployee);
        }
        return getAllEmployees;
    }

    @Override
    public Optional<GetOneEmployeeResponse> getOneByName(String name) {
        Employee employee = employeeRepository.getOneByName(name);
        GetOneEmployeeResponse getOneEmployeeResponse = new GetOneEmployeeResponse();
        getOneEmployeeResponse.setName(employee.getName());
        getOneEmployeeResponse.setEmail(employee.getEmail());
        getOneEmployeeResponse.setJobTitle(employee.getJobTitle());
        getOneEmployeeResponse.setPhone(employee.getPhone());
        getOneEmployeeResponse.setImageUrl(employee.getImageUrl());
        getOneEmployeeResponse.setIsManager(employee.getIsManager());
        getOneEmployeeResponse.setEmployeeCode(employee.getEmployeeCode());
        return Optional.of(getOneEmployeeResponse);

    }

    @Override
    public GetOneEmployeeResponse CreateEmployee(CreateEmployeeRequest createEmployeeRequest) {
        Employee employee = new Employee();
        employee.setName(createEmployeeRequest.getName());
        employee.setEmail(createEmployeeRequest.getEmail());
        employee.setJobTitle(createEmployeeRequest.getJobTitle());
        employee.setPhone(createEmployeeRequest.getPhone());
        employee.setImageUrl(createEmployeeRequest.getImageUrl());
        employee.setIsManager(createEmployeeRequest.getIsManager());
        employee.setEmployeeCode(createEmployeeRequest.getEmployeeCode());
        employeeRepository.save(employee);
        GetOneEmployeeResponse getOneEmployeeResponse = new GetOneEmployeeResponse();
        getOneEmployeeResponse.setName(employee.getName());
        getOneEmployeeResponse.setEmail(employee.getEmail());
        getOneEmployeeResponse.setJobTitle(employee.getJobTitle());
        getOneEmployeeResponse.setPhone(employee.getPhone());
        getOneEmployeeResponse.setImageUrl(employee.getImageUrl());
        getOneEmployeeResponse.setIsManager(employee.getIsManager());
        getOneEmployeeResponse.setEmployeeCode(employee.getEmployeeCode());
        return getOneEmployeeResponse;
    }

    @Override
    public void DeleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
