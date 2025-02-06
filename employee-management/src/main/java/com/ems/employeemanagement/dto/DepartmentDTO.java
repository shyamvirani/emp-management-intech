package com.ems.employeemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import java.util.List;

@Data
public class DepartmentDTO {
    private Long id;
    private String name;
    private String location;

    private List<EmployeeDTO> employees;

    public DepartmentDTO(Long id, String name, String location, List<EmployeeDTO> employees) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.employees = employees;
    }
}
