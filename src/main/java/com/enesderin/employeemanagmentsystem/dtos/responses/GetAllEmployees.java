package com.enesderin.employeemanagmentsystem.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllEmployees {
    private int Id;
    private String Name;
    private String Email;
    private String JobTitle;
    private String Phone;
}
