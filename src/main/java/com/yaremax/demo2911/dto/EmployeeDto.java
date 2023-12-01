package com.yaremax.demo2911.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.yaremax.demo2911.data.Employee}
 */
@Value
public class EmployeeDto implements Serializable {
    Integer id;
    String lastName;
    String firstName;
    String title;
    String reportsToLastName;
    String reportsToFirstName;
    String phone;
}