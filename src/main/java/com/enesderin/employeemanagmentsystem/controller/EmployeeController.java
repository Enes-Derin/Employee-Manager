package com.enesderin.employeemanagmentsystem.controller;

import com.enesderin.employeemanagmentsystem.business.concretes.EmployeeManager;
import com.enesderin.employeemanagmentsystem.dtos.requests.CreateEmployeeRequest;
import com.enesderin.employeemanagmentsystem.dtos.requests.UpdateEmployeeRequest;
import com.enesderin.employeemanagmentsystem.dtos.responses.GetAllEmployees;
import com.enesderin.employeemanagmentsystem.dtos.responses.GetOneEmployeeResponse;
import com.enesderin.employeemanagmentsystem.dtos.responses.UpdatedEmployeeResponse;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeManager employeeService;

    @GetMapping
    public ModelAndView getAllEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return new ModelAndView("index.html");
    }

    @GetMapping("/create")
    public ModelAndView createEmployee(Model model) {
        model.addAttribute("createEmployeeRequest", new CreateEmployeeRequest());
        return new ModelAndView("create.html");
    }

    @PostMapping("/create")
    public ModelAndView createEmployee(@ModelAttribute("createEmployeeRequest") CreateEmployeeRequest createEmployeeRequest) {
        employeeService.CreateEmployee(createEmployeeRequest);
        return new ModelAndView("index.html");
    }

    @GetMapping("/{id}")
    public GetOneEmployeeResponse getOneById(@PathVariable int id)  {
        return employeeService.getOneById(id);
    }

    @PutMapping("/{id}")
    public UpdatedEmployeeResponse updateEmployee(@PathVariable int id, @RequestBody UpdateEmployeeRequest updateEmployeeRequest) {
        return this.employeeService.UpdateEmployee(id, updateEmployeeRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.DeleteEmployee(id);
    }
}
