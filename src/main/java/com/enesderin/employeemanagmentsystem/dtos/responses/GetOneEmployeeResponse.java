package com.enesderin.employeemanagmentsystem.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetOneEmployeeResponse {
    private int Id;
    private String name;
    private String email;
    private String jobTitle;
    private String phone;
}
