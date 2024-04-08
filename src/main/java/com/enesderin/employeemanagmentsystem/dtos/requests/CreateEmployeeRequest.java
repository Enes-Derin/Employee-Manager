package com.enesderin.employeemanagmentsystem.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeRequest {

    private String Name;
    private String Email;
    private String JobTitle;
    private String Phone;
    private String ImageUrl;
    private Boolean IsManager;
    private  String EmployeeCode;
}
