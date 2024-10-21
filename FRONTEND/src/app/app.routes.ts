import { Routes } from '@angular/router';
import { EmployeeComponent } from './employee/employee.component';
import { AddEmployeeComponent } from './add-employee/add-employee.component';

export const routes: Routes = [
    {
        path:'employee',
        component:EmployeeComponent

    }
    ,
    {
        path:'addemployee',
        component:AddEmployeeComponent
    }
];
