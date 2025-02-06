import { Routes } from "@angular/router";

export const appRoutes: Routes = [
   { path: '', redirectTo: 'employees', pathMatch: 'full' },
   { path: '**', redirectTo: 'employees', pathMatch: 'full' }
]