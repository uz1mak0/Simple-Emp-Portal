package com.example.Simple_Emp_Job_Portal.Controller;

import com.example.Simple_Emp_Job_Portal.Repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Registration")
public class RegistrationController {

    @Autowired
    private RegistrationRepository regRepo;

}
