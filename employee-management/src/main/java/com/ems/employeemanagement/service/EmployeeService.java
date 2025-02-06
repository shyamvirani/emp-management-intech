package com.ems.employeemanagement.service;

import com.ems.employeemanagement.dto.request.CreateEmployeeRequest;
import com.ems.employeemanagement.dto.EmployeeDTO;
import com.ems.employeemanagement.entitiy.Department;
import com.ems.employeemanagement.entitiy.Employee;
import com.ems.employeemanagement.exception.CommonException;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    void createEmployee(CreateEmployeeRequest createEmployeeRequest) throws CommonException;

    List<EmployeeDTO> findByDepartmentId(Long id);

    List<Employee> getAll();

    void deleteEmployeeByIdAndDepartment(Long employeeId, Long departmentId) throws CommonException;

    List<Employee> findByDepartment(Department department);

    EmployeeDTO findByEmployeeId(Long employeeId) throws CommonException;
}
