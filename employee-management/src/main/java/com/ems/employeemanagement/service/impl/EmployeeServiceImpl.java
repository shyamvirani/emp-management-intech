package com.ems.employeemanagement.service.impl;

import com.ems.employeemanagement.dto.request.CreateEmployeeRequest;
import com.ems.employeemanagement.dto.EmployeeDTO;
import com.ems.employeemanagement.entitiy.Department;
import com.ems.employeemanagement.entitiy.Employee;
import com.ems.employeemanagement.exception.CommonException;
import com.ems.employeemanagement.repository.EmployeeRepository;
import com.ems.employeemanagement.service.DepartmentService;
import com.ems.employeemanagement.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final DepartmentService departmentService;

    @Override
    public void createEmployee(CreateEmployeeRequest createEmployeeRequest) throws CommonException {
        Employee employee = new Employee();
        if (createEmployeeRequest.getId() != null) {
            Optional<Employee> employeeOptional = employeeRepository.findById(createEmployeeRequest.getId());
            if (employeeOptional.isPresent()) {
                employee = employeeOptional.get();
            } else {
                log.error("Employee with id {} not found ", createEmployeeRequest.getId());
                return;
            }
        }
        BeanUtils.copyProperties(createEmployeeRequest, employee);
        Department department = departmentService.getDepartmentById(createEmployeeRequest.getDepartmentId());
        if (department == null)
            throw new CommonException("Department not found with id " + createEmployeeRequest.getDepartmentId());
        employee.setDepartment(department);
        employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeDTO> findByDepartmentId(Long id) {
        Department department = departmentService.getDepartmentById(id);
        return employeeRepository.findByDepartment(department).stream()
                .map(employee -> new EmployeeDTO(employee.getId(), employee.getName(), employee.getEmail(), employee.getPosition(), employee.getSalary()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteEmployeeByIdAndDepartment(Long employeeId, Long departmentId) throws CommonException {
        Department department = departmentService.getDepartmentById(departmentId);
        Employee employee = employeeRepository.findByIdAndDepartment(employeeId, department);
        if (employee != null) {
            employeeRepository.delete(employee);
        } else {
            throw new CommonException("Employee not exist with user id " + employeeId + " in department " + departmentId);
        }
    }

    @Override
    public List<Employee> findByDepartment(Department department) {
        return employeeRepository.findByDepartment(department);
    }

    @Override
    public EmployeeDTO findByEmployeeId(Long employeeId) throws CommonException {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setId(employee.getId());
            employeeDTO.setName(employee.getName());
            employeeDTO.setEmail(employee.getEmail());
            employeeDTO.setSalary(employee.getSalary());
            employeeDTO.setPosition(employee.getPosition());
            return employeeDTO;
        } else {
            throw new CommonException("Employee not found with id " + employeeId);
        }
    }
}

