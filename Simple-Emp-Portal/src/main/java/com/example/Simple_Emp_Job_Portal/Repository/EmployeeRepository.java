package com.example.Simple_Emp_Job_Portal.Repository;

import com.example.Simple_Emp_Job_Portal.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
