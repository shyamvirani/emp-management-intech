package com.ems.employeemanagement.repository;

import com.ems.employeemanagement.entitiy.Department;
import com.ems.employeemanagement.entitiy.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByDepartment(Department department);

    Employee findByIdAndDepartment(Long employeeId, Department department);
}