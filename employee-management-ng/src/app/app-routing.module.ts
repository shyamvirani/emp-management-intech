import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { ShowDetailsComponent } from './show-details/show-details.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  { path: '', redirectTo: "home", pathMatch: "full" },
  { path: 'employee-details/:id', component: ShowDetailsComponent },
  { path: 'home', component: HomeComponent },
  { path: 'employees/:deptId', component: EmployeeListComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
