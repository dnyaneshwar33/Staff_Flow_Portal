package com.example.empbackend.employee;

import com.example.empbackend.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/emp/add")
    public ResponseEntity<Employee> saveEmployee( @RequestBody Employee employee){
        try {
            Employee newEmp=employeeService.addNew(employee);

            return new ResponseEntity<>(newEmp, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/emp/all")
    public ResponseEntity<List<Employee>>getALlEmp(){
        try {
            List<Employee> allEmp=employeeService.getAllEmp();

            return new ResponseEntity<>(allEmp,HttpStatus.FOUND);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/emp/{empId}")
    public ResponseEntity<Employee>getEmpById(@PathVariable Long empId){
        try {
            Employee employee=employeeService.getEmployee(empId);
            return new ResponseEntity<>(employee,HttpStatus.FOUND);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    @PostMapping("/emp/update/{empId}")
    public ResponseEntity<Employee>updateEmp(@RequestBody Employee empData,@PathVariable Long empId){
        try {
            Employee updatedEmp=employeeService.updateEmployee(empId,empData);

            return new ResponseEntity<>(updatedEmp,HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/emp/delete/{empId}")
    public ResponseEntity<String>deletEmp(@PathVariable Long empId){
        try {
            employeeService.deleteEmp(empId);

            return new ResponseEntity<>("Empploye deleted success" ,HttpStatus.ACCEPTED);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException(e.getMessage());
        }

    }



}
