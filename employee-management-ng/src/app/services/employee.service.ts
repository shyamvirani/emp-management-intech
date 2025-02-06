import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';
import { Employee } from '../employee';


@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseURL = "http://localhost:8070/employee";

  constructor(private httpClient: HttpClient) { }

  getEmployeeById(id: number): Observable<Employee> {
    return this.httpClient.get<Employee>(`${this.baseURL}/${id}`);
  }

  getEmployeeByDepartmentId(departmentId: number): Observable<Employee> {
    return this.httpClient.get<Employee>(`${this.baseURL}/department/${departmentId}`);
  }

  deleteEmployee(employeeId: number, departmentId: number): Observable<Object> {
    return this.httpClient.delete(`${this.baseURL}/${employeeId}/department/${departmentId}`);
  }
}
