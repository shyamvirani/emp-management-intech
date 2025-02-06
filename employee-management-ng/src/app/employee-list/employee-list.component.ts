import { Component } from '@angular/core';
import { EmployeeService } from '../services/employee.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent {

  employees: any = [];
  departmentId: any;

  constructor(private employeeService: EmployeeService,
    private activatedRoute: ActivatedRoute,
    private router: Router) {
  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(params => {
      this.departmentId = params['deptId'];
      this.getEmployees(this.departmentId);
    });
  }

  getEmployees(departmentId: number) {
    this.employeeService.getEmployeeByDepartmentId(this.departmentId).subscribe(data => {
      this.employees = data['responseData'];
    });
  }

  deleteEmployee(id: number) {
    if (confirm("Are you sure to delete Employee ID: " + id)) {
      this.employeeService.deleteEmployee(id, this.departmentId).subscribe(data => {
        this.getEmployees(this.departmentId);
      });
    }
  }

  detailsOfEmployee(id: number) {
    this.router.navigate(['employee-details', id]);
  }
}
