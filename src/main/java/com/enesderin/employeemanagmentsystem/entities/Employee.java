package com.enesderin.employeemanagmentsystem.entities;

import jakarta.persistence.*;
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
    private String name;
    private String email;
    private String jobTitle;
    private String phone;
    private Boolean isManager;
    private String employeeCode;

}
