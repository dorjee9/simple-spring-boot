package com.simplecode.demo.service;

import com.simplecode.demo.exception.EmployeeNotFoundException;
import com.simplecode.demo.model.Employee;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private List<Employee> employeesList = new ArrayList<>();
    @Override
    public Employee save(Employee employee) {
        if(employee.getEmployeeId() == null || employee.getEmployeeId().isEmpty()){
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        employeesList.add(employee);
        return employee;
    }




    @Override
    public List<Employee> findAll() {
        return employeesList;
    }

    @Override
    public Employee findById(String employeeId) {

        return employeesList.stream().filter(employee -> employee.getEmployeeId().equals(employeeId)).findFirst().orElseThrow(()->new EmployeeNotFoundException("Employee not found with Id:"+employeeId));
    }

    @Override
    public String deleteById(String employeeId) {
         Employee emp = employeesList.stream().filter(employee -> employee.getEmployeeId().equals(employeeId)).findFirst().orElseThrow(()->new EmployeeNotFoundException("Employee not found with Id:"+employeeId));
        employeesList.remove(emp);
        return "Employee is deleted by Id:"+employeeId;
    }
}
