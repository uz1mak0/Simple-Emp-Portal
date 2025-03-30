package com.example.Simple_Emp_Job_Portal.Repository;

import com.example.Simple_Emp_Job_Portal.Entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {}
