package com.example.empbackend.employee;


import com.example.empbackend.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    Employee addNew(Employee empData){
       return employeeRepository.save(empData);
    }

    List<Employee>getAllEmp(){
        return employeeRepository.findAll();
    }

    Employee getEmployee(Long empId){
        return employeeRepository.findById(empId).orElseThrow(()->new ResourceNotFoundException("Employee Not found"));
    }

    Employee updateEmployee(Long empId,Employee empData){
        Employee oldEmp=getEmployee(empId);

        oldEmp.setFirstname(empData.getFirstname());
        oldEmp.setLastname(empData.getLastname());
        oldEmp.setEmail(empData.getEmail());
        oldEmp.setEmpsalary(empData.getEmpsalary());

        return employeeRepository.save(oldEmp);
    }

    void deleteEmp(Long empId){
        employeeRepository.findById(empId).ifPresentOrElse(employeeRepository::delete,
                ()-> {throw new ResourceNotFoundException("employee record not found");}

        );

    }

}
