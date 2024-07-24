package org.iase24.com.controller;

import lombok.RequiredArgsConstructor;
import org.iase24.com.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @GetMapping("/e")
    public String  getAllEmployee() {
        return "All employee";
    }
}
