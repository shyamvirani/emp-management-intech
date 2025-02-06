package com.ems.employeemanagement.controller;

import com.ems.employeemanagement.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reports")
public class ReportController {

    private final ReportService reportService;


    @GetMapping("/generate-department-report")
    public ResponseEntity<?> generateReport(HttpServletResponse response) {
        try {
            String reportPath = "src/main/resources/report/department_report.pdf";
            reportService.generateDepartmentReport(reportPath);
            File reportFile = new File(reportPath);
            FileInputStream fileInputStream = new FileInputStream(reportFile);
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "inline; filename=department_report.pdf");
            org.apache.commons.io.IOUtils.copy(fileInputStream, response.getOutputStream());
            response.flushBuffer();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error generating report");
        }
        return ResponseEntity.ok().build();
    }
}