package com.enesderin.employeemanagmentsystem.dtos.requests;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeRequest {

    @NotNull(message = "Name cannot be null")
    private String Name;

    @NotNull(message = "Email cannot be null")
    private String Email;

    @NotNull(message = "JobTitle cannot be null")
    private String JobTitle;

    @NotNull(message = "Phone cannot be null")
    private String Phone;

}
