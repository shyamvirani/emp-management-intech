package com.ems.employeemanagement.service.impl;

import com.ems.employeemanagement.dto.EmployeeDTO;
import com.ems.employeemanagement.entitiy.Department;
import com.ems.employeemanagement.entitiy.Employee;
import com.ems.employeemanagement.repository.DepartmentRepository;
import com.ems.employeemanagement.repository.EmployeeRepository;
import com.ems.employeemanagement.service.ReportService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public void generateDepartmentReport(String filePath) throws JRException {
        // Fetch departments with their employees
        List<Department> departments = departmentRepository.findAll();

        // Prepare data for the report
        for (Department department : departments) {
            List<Employee> employees = employeeRepository.findByDepartment(department);
            List<EmployeeDTO> employeeDTOs = employees.stream()
                    .map(emp -> new EmployeeDTO(emp.getId(), emp.getName(), emp.getEmail(), emp.getPosition(), emp.getSalary()))
                    .collect(Collectors.toList());

            Map<String, Object> parameters = Map.of(
                    "departmentName", department.getName()
            );

            // Create the data source for the report
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employeeDTOs);

            // Compile and fill the report
            InputStream jasperStream = getClass().getResourceAsStream("/report/department_report.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperStream);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

            // Export the report to PDF
            File reportFile = new File(filePath);
            JasperExportManager.exportReportToPdfFile(jasperPrint, reportFile.getAbsolutePath());
        }
    }
}
