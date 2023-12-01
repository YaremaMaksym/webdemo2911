package com.yaremax.demo2911.controllers;

import com.yaremax.demo2911.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public String showEmployees(Model model) {
        model.addAttribute("employees", employeeService.getEmployees());
        return "employees";
    }
}
