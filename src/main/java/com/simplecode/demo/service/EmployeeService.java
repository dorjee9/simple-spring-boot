package com.simplecode.demo.service;

import com.simplecode.demo.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee employee);

     List<Employee> findAll();

    Employee findById(String employeeId);

    String deleteById(String employeeId);
}
