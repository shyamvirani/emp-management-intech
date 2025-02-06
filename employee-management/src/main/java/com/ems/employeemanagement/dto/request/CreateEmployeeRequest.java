package com.ems.employeemanagement.dto.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CreateEmployeeRequest {

    private Long id;

    @NotEmpty(message = "The name is required.")
    @NotNull
    private String name;

    @Email
    private String email;

    private String position;

    private double salary;

    @NotNull
    private Long departmentId;

}
