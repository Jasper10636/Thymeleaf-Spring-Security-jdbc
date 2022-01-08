package com.example.springboot.thymeleafdemo.service;

import com.example.springboot.thymeleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    Employee findById(int theId);

    void save(Employee employee);

    void deleteById(int theId);

    public List<Employee> searchBy(String theName);

}
