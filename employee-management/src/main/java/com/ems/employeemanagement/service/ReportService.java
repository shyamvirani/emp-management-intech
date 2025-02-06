package com.ems.employeemanagement.service;

import net.sf.jasperreports.engine.JRException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ReportService {
    public void generateDepartmentReport(String filePath) throws JRException ;
}
