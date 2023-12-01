package com.yaremax.demo2911.services;

import com.yaremax.demo2911.data.Employee;
import com.yaremax.demo2911.dto.EmployeeDto;
import com.yaremax.demo2911.mappers.EmployeeMapper;
import com.yaremax.demo2911.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public List<EmployeeDto> getEmployees() {
        return employeeRepository.findAll().stream()
                .map(employeeMapper::employeeToDto)
                .toList();
    }
}
