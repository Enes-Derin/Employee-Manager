package com.enesderin.employeemanagmentsystem.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployeeRequest {
    private String name;
    private String email;
    private String jobTitle;
    private String phone;
    private Boolean isManager;
    private String employeeCode;
}
