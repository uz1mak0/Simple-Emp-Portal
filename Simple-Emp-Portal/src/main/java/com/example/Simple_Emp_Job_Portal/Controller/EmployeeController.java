package com.example.Simple_Emp_Job_Portal.Controller;

import com.example.Simple_Emp_Job_Portal.Entity.Employee;
import com.example.Simple_Emp_Job_Portal.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/Employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository empRepo;


    @PostMapping("/save")
    @Secured("EMP")
    public ResponseEntity<Employee> saveEmp(@RequestBody Employee emp) {
        Employee employee = empRepo.save(emp);

        return new ResponseEntity<>(employee, HttpStatus.CREATED);
        }

    @PutMapping("/update/{empId}")
    @Secured("ADMIN")
    public Optional<Employee> updateEmployee(@PathVariable(value = "id") Long empId) throws RuntimeException {
              Optional<Employee> employee = empRepo.findById(empId);
              if (employee.isPresent()) {
                  employee.get().setName("");
                  employee.get().setRole("");
              }else{
                  System.out.println("Employee with the id of " + empId + "not found");
              }
              return employee;
        }

    @DeleteMapping("/delete/{empId}")
    @Secured("ADMIN")
    public void deleteEmployeeById(@PathVariable(value = "id") long empId) {
            empRepo.deleteById(empId);
        }
    }
