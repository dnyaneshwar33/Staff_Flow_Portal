import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-add-employee',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './add-employee.component.html',
  styleUrl: './add-employee.component.css'
})
export class AddEmployeeComponent {

  formData=new FormGroup({
    firstname:new FormControl(),
    lastname:new FormControl(),
    email:new FormControl(),
    empsalary:new FormControl()
  })

  constructor(private http:HttpClient){
    console.log("called");

  }

 

  addEmployee(){
    this.http.post("http://localhost:8080/api/employee/emp/add",this.formData.value).subscribe((res:any)=>{

      if(res){
        alert("employee added");

      }

      else{
        alert(res.message);

      }
    })
    

  }

}
