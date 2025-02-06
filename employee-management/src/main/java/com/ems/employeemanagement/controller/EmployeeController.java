package com.ems.employeemanagement.controller;

import com.ems.employeemanagement.dto.request.CreateEmployeeRequest;
import com.ems.employeemanagement.dto.EmployeeDTO;
import com.ems.employeemanagement.entitiy.Employee;
import com.ems.employeemanagement.exception.CommonException;
import com.ems.employeemanagement.rest.RestResponse;
import com.ems.employeemanagement.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
@CrossOrigin("*")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public RestResponse createEmployee(@Valid @RequestBody CreateEmployeeRequest createEmployeeRequest) throws CommonException {
        RestResponse restResponse = new RestResponse();
        employeeService.createEmployee(createEmployeeRequest);
        restResponse.setResponseData("Employee Data Saved Successfully!!!");
        restResponse.getMetadata().setSuccessOutcome();
        return restResponse;
    }

    @GetMapping
    public RestResponse getEmployees() {
        RestResponse restResponse = new RestResponse();
        List<Employee> employees = employeeService.getAll();
        restResponse.setResponseData(employees);
        restResponse.getMetadata().setSuccessOutcome();
        return restResponse;
    }

    @GetMapping("/department/{departmentId}")
    public RestResponse getEmployeesByDepartment(@PathVariable Long departmentId) {
        RestResponse restResponse = new RestResponse();
        List<EmployeeDTO> employees = employeeService.findByDepartmentId(departmentId);
        restResponse.setResponseData(employees);
        restResponse.getMetadata().setSuccessOutcome();
        return restResponse;
    }

    @GetMapping("/{employeeId}")
    public RestResponse getEmployeesByEmployeeId(@PathVariable Long employeeId) throws CommonException {
        RestResponse restResponse = new RestResponse();
        EmployeeDTO employee = employeeService.findByEmployeeId(employeeId);
        restResponse.setResponseData(employee);
        restResponse.getMetadata().setSuccessOutcome();
        return restResponse;
    }

    @DeleteMapping("{employeeId}/department/{departmentId}")
    public RestResponse deleteEmployeeByIdAndDepartment(@PathVariable Long employeeId, @PathVariable Long departmentId) throws CommonException {
        RestResponse restResponse = new RestResponse();
        employeeService.deleteEmployeeByIdAndDepartment(employeeId, departmentId);
        restResponse.setResponseData("Employee deleted successfully!!!");
        restResponse.getMetadata().setSuccessOutcome();
        return restResponse;
    }
}
