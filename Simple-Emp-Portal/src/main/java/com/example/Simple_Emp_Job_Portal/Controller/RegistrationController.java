package com.example.Simple_Emp_Job_Portal.Controller;

import com.example.Simple_Emp_Job_Portal.Entity.Registration;
import com.example.Simple_Emp_Job_Portal.Repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Registration")
public class RegistrationController {

    @Autowired
    private RegistrationRepository regRepo;

    @PostMapping("/save")
    public Registration saveNewRegUser(@RequestBody Registration registration) {
        return regRepo.save(registration);
    }

    @GetMapping("/saved/NewUser")
    public String newUser(@PathVariable(value = "id") long id) {
        return id + "has Successfully registered";
    }
}
