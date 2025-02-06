package com.ems.employeemanagement.service;

import com.ems.employeemanagement.dto.DepartmentDTO;
import com.ems.employeemanagement.dto.request.CreateDepartmentRequest;
import com.ems.employeemanagement.entitiy.Department;
import com.ems.employeemanagement.exception.CommonException;

import java.util.List;

public interface DepartmentService {

    void createDepartment(CreateDepartmentRequest createDepartmentRequest) throws CommonException;

    Department getDepartmentById(Long departmentId);

    List<DepartmentDTO> getAll();

}
