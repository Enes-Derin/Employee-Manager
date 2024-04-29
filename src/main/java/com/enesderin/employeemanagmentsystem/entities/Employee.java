package com.enesderin.employeemanagmentsystem.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "employees")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Name cannot be null")
    private String name;

    @NotNull(message = "Email cannot be null")
    private String email;

    @NotNull(message = "JobTitle cannot be null")
    private String jobTitle;

    @NotNull(message = "Phone cannot be null")
    private String phone;

    @NotNull(message = "IsManager cannot be null")
    private Boolean isManager;

    @NotNull(message = "EmployeeCode cannot be null")
    private String employeeCode;
}
