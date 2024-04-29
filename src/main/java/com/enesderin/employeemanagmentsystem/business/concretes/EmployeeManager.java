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
        List<GetAllEmployees> getAllEmployees = new ArrayList<GetAllEmployees>();

        return modelMapper.map(employees, getAllEmployees.getClass());
    }

    @Override
    public GetOneEmployeeResponse getOneById(int id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Employee not found"));
        return modelMapper.map(employee, GetOneEmployeeResponse.class);


    }

    @Override
    public GetOneEmployeeResponse CreateEmployee(CreateEmployeeRequest createEmployeeRequest) {
        Employee employee = new Employee();
        modelMapper.map(createEmployeeRequest, employee);
        employeeRepository.save(employee);
        GetOneEmployeeResponse getOneEmployeeResponse = new GetOneEmployeeResponse();
        modelMapper.map(employee, getOneEmployeeResponse);
        return getOneEmployeeResponse;
    }

    @Override
    public UpdatedEmployeeResponse UpdateEmployee(int id, UpdateEmployeeRequest updateEmployeeRequest) {

        Employee employee = employeeRepository.findById(id).orElse(null);
        UpdatedEmployeeResponse updatedEmployeeResponse = new UpdatedEmployeeResponse();
        modelMapper.map(updateEmployeeRequest, employee);
        this.employeeRepository.save(employee);
        modelMapper.map(employee, updatedEmployeeResponse);
        return updatedEmployeeResponse;
    }

    @Override
    public void DeleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
