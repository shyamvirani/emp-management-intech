package com.ems.employeemanagement.controller;

import com.ems.employeemanagement.dto.DepartmentDTO;
import com.ems.employeemanagement.dto.request.CreateDepartmentRequest;
import com.ems.employeemanagement.entitiy.Department;
import com.ems.employeemanagement.exception.CommonException;
import com.ems.employeemanagement.rest.RestResponse;
import com.ems.employeemanagement.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
@CrossOrigin("*")
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public RestResponse createDepartment(@RequestBody CreateDepartmentRequest createDepartmentRequest) throws CommonException {
        RestResponse restResponse = new RestResponse();
        departmentService.createDepartment(createDepartmentRequest);
        restResponse.setResponseData("Department created successfully!");
        restResponse.getMetadata().setSuccessOutcome();
        return restResponse;
    }

    @GetMapping("/{departmentId}")
    public RestResponse getDepartmentById(@PathVariable(value = "departmentId") long departmentId) {
        RestResponse restResponse = new RestResponse();
        Department department = departmentService.getDepartmentById(departmentId);
        restResponse.setResponseData(department);
        restResponse.getMetadata().setSuccessOutcome();
        return restResponse;
    }

    @GetMapping
    public RestResponse getAllDepartments() {
        RestResponse restResponse = new RestResponse();
        List<DepartmentDTO> departments = departmentService.getAll();
        restResponse.setResponseData(departments);
        restResponse.getMetadata().setSuccessOutcome();
        return restResponse;
    }
}
