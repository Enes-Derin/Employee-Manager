package com.enesderin.employeemanagmentsystem.business.concretes;

import com.enesderin.employeemanagmentsystem.business.abstracts.EmployeeService;
import com.enesderin.employeemanagmentsystem.dtos.requests.CreateEmployeeRequest;
import com.enesderin.employeemanagmentsystem.dtos.requests.UpdateEmployeeRequest;
import com.enesderin.employeemanagmentsystem.dtos.responses.GetAllEmployees;
import com.enesderin.employeemanagmentsystem.dtos.responses.GetOneEmployeeResponse;
import com.enesderin.employeemanagmentsystem.dtos.responses.UpdatedEmployeeResponse;
import com.enesderin.employeemanagmentsystem.entities.Employee;
import com.enesderin.employeemanagmentsystem.exception.NotFoundException;
import com.enesderin.employeemanagmentsystem.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
    @Override
    public List<GetAllEmployees> getAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();
        return modelMapper.map(employees, new ArrayList<GetAllEmployees>().getClass());
    }

    @Override
    public GetOneEmployeeResponse getOneById(int id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Employee not found"));
        return modelMapper.map(employee, GetOneEmployeeResponse.class);


    }

    @Override
    public GetOneEmployeeResponse CreateEmployee(CreateEmployeeRequest createEmployeeRequest) {
        Employee employee = new Employee();
        employee.setName(createEmployeeRequest.getName());
        employee.setEmail(createEmployeeRequest.getEmail());
        employee.setJobTitle(createEmployeeRequest.getJobTitle());
        employee.setPhone(createEmployeeRequest.getPhone());
        employee.setIsManager(createEmployeeRequest.getIsManager());
        employee.setEmployeeCode(createEmployeeRequest.getEmployeeCode());
        employeeRepository.save(employee);
        GetOneEmployeeResponse getOneEmployeeResponse = new GetOneEmployeeResponse();
        modelMapper.map(employee, getOneEmployeeResponse);
        return getOneEmployeeResponse;
    }

    @Override
    public UpdatedEmployeeResponse updateEmployee(int id, UpdateEmployeeRequest updateEmployeeRequest) {

        Employee employee = employeeRepository.findById(id).get();

        employee.setName(updateEmployeeRequest.getName());
        employee.setEmail(updateEmployeeRequest.getEmail());
        employee.setJobTitle(updateEmployeeRequest.getJobTitle());
        employee.setPhone(updateEmployeeRequest.getPhone());
        employee.setIsManager(updateEmployeeRequest.getIsManager());
        employee.setEmployeeCode(updateEmployeeRequest.getEmployeeCode());
        employeeRepository.save(employee);
        UpdatedEmployeeResponse updatedEmployeeResponse = new UpdatedEmployeeResponse();
        modelMapper.map(employee, updatedEmployeeResponse);
        return updatedEmployeeResponse;
    }

    @Override
    public void DeleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
