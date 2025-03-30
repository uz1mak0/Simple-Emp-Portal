package com.example.Simple_Emp_Job_Portal.Controller;

import com.example.Simple_Emp_Job_Portal.Entity.Login;
import com.example.Simple_Emp_Job_Portal.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/Login")
public class LoginController {

    @Autowired
    private LoginRepository loginRepository;


    @PostMapping("/saveUser")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Login> saveUser(@RequestBody Login login) {
        Login saveUser = loginRepository.save(login);

        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
    }

    @GetMapping("/user/{id}")
    @PreAuthorize("hasAnyRole('USER')")
    public Optional<Login> getUserById(@PathVariable(value = "id") long id) {
        Optional<Login> findUserById = loginRepository.findById(id);
            try {
                if(findUserById.isPresent()) {
                    return new ResponseEntity<>(findUserById, HttpStatus.OK).getBody();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return findUserById;
    }
}
