package com.ems.employeemanagement.service.impl;

import com.ems.employeemanagement.dto.DepartmentDTO;
import com.ems.employeemanagement.dto.EmployeeDTO;
import com.ems.employeemanagement.dto.request.CreateDepartmentRequest;
import com.ems.employeemanagement.entitiy.Department;
import com.ems.employeemanagement.exception.CommonException;
import com.ems.employeemanagement.repository.DepartmentRepository;
import com.ems.employeemanagement.repository.EmployeeRepository;
import com.ems.employeemanagement.service.DepartmentService;
import com.ems.employeemanagement.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    private final EmployeeRepository employeeRepository;

    @Override
    public void createDepartment(CreateDepartmentRequest createDepartmentRequest) throws CommonException {
        if (createDepartmentRequest.getId() != null) {
            Optional<Department> departmentOptional = departmentRepository.findById(createDepartmentRequest.getId());
            if (departmentOptional.isPresent()) {
                Department department = departmentOptional.get();
                department.setName(createDepartmentRequest.getName());
                departmentRepository.save(department);
            } else {
                log.error("Department with id {} not found ", createDepartmentRequest.getId());
                throw new CommonException("Department not found with id " + createDepartmentRequest.getId());
            }
        } else {
            Department department = new Department();
            department.setName(createDepartmentRequest.getName());
            department.setLocation(createDepartmentRequest.getLocation());
            departmentRepository.save(department);
        }
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).orElse(null);
    }

    @Override
    public List<DepartmentDTO> getAll() {
        List<Department> departments = departmentRepository.findAll();

        return departments.stream().map(department -> {
            List<EmployeeDTO> employeeDTOs = employeeRepository.findByDepartment(department).stream()
                    .map(emp -> new EmployeeDTO(emp.getId(), emp.getName(), emp.getEmail(), emp.getPosition(), emp.getSalary()))
                    .collect(Collectors.toList());

            return new DepartmentDTO(department.getId(), department.getName(), department.getLocation(), employeeDTOs);
        }).collect(Collectors.toList());
    }
}
