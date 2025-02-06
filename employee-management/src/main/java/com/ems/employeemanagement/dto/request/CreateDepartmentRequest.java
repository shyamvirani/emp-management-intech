package com.ems.employeemanagement.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreateDepartmentRequest {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String location;
}
