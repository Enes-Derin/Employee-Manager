package com.enesderin.employeemanagmentsystem.controller;

import com.enesderin.employeemanagmentsystem.business.concretes.EmployeeManager;
import com.enesderin.employeemanagmentsystem.dtos.requests.CreateEmployeeRequest;
import com.enesderin.employeemanagmentsystem.dtos.requests.UpdateEmployeeRequest;
import com.enesderin.employeemanagmentsystem.dtos.responses.GetAllEmployees;
import com.enesderin.employeemanagmentsystem.dtos.responses.GetOneEmployeeResponse;
import com.enesderin.employeemanagmentsystem.dtos.responses.UpdatedEmployeeResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeManager employeeService;

    @GetMapping
    public String getAllEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "index";
    }

    @GetMapping("/create")
    public String viewCreateEmployee(Model model) {
        model.addAttribute("createEmployeeRequest", new CreateEmployeeRequest());
        return "create";
    }


    @PostMapping("/create")
    public String createEmployee(@ModelAttribute CreateEmployeeRequest createEmployeeRequest) {
        employeeService.CreateEmployee(createEmployeeRequest);
        return "redirect:/employee";
    }

    @GetMapping("/update/{id}")
    public String  updateEmployee(@PathVariable int id, Model model) {
        model.addAttribute("updateEmployeeRequest", this.employeeService.getOneById(id));
        return "update";
    }
    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable int id,@ModelAttribute UpdateEmployeeRequest updateEmployeeRequest) {
        employeeService.updateEmployee(id, updateEmployeeRequest);
        return "redirect:/employee";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeService.DeleteEmployee(id);
        return "redirect:/employee";
    }
}
