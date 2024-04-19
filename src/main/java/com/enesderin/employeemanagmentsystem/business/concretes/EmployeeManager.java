package com.enesderin.employeemanagmentsystem.business.concretes;

import com.enesderin.employeemanagmentsystem.business.abstracts.EmployeeService;
import com.enesderin.employeemanagmentsystem.dtos.requests.CreateEmployeeRequest;
import com.enesderin.employeemanagmentsystem.dtos.responses.GetAllEmployees;
import com.enesderin.employeemanagmentsystem.dtos.responses.GetOneEmployeeResponse;
import com.enesderin.employeemanagmentsystem.entities.Employee;
import com.enesderin.employeemanagmentsystem.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.Errors;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
    @Override
    public List<GetAllEmployees> getAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();
        List<GetAllEmployees> getAllEmployees = modelMapper.map(employees, new ArrayList<GetAllEmployees>().getClass());

        return getAllEmployees;
    }

    @Override
    public Optional<GetOneEmployeeResponse> getOneById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        GetOneEmployeeResponse getOneEmployeeResponse = new GetOneEmployeeResponse();
        if (employee.isPresent()) {
            modelMapper.map(employee, getOneEmployeeResponse);
        }
        return Optional.of(getOneEmployeeResponse);


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
    public void DeleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
