package com.simplecode.demo.controller;

import com.simplecode.demo.model.Employee;
import com.simplecode.demo.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Qualifier("employeeServiceImpl")
    @Autowired()
    private EmployeeService employeeService;
    @PostMapping
    public Employee save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }
    @GetMapping
    public List<Employee> findAll(){
        return employeeService.findAll();
    }
    @GetMapping("/{employeeId}")
    public Employee findById(@PathVariable String employeeId){
        return employeeService.findById(employeeId);
    }
    @DeleteMapping("/{employeeId}")
    public String deleteById(@PathVariable String employeeId){
        return employeeService.deleteById(employeeId);
    }
}
