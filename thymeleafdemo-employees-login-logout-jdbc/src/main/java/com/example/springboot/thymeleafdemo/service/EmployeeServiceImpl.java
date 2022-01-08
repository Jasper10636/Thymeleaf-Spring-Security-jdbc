package com.example.springboot.thymeleafdemo.service;

import com.example.springboot.thymeleafdemo.dao.EmployeeReposiptory;
import com.example.springboot.thymeleafdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{


    private EmployeeReposiptory employeeReposiptory;

    @Autowired
    public EmployeeServiceImpl(EmployeeReposiptory theEmployeeReposiptory) {
        this.employeeReposiptory = theEmployeeReposiptory;
    }

    // remove @Transactional
    // since JpaRepository already provides this functionality

    @Override
    public List<Employee> findAll() {
        return employeeReposiptory.findAllByOrderByLastNameAsc();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeReposiptory.findById(theId);

        Employee theEmployee = null;
        if(result.isPresent()){
            theEmployee = result.get();
        }else{
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theEmployee;
//        return employeeReposiptory.findById(theId);
    }

    @Override
    public void save(Employee employee) {
        employeeReposiptory.save(employee);
    }

    @Override
    public void deleteById(int theId) {
        employeeReposiptory.deleteById(theId);
    }

    @Override
    public List<Employee> searchBy(String theName) {

        List<Employee> results = null;

        if(theName != null && (theName.trim().length() > 0)){
            results = employeeReposiptory.findByFirstNameContainsOrLastNameContainsAllIgnoreCase(theName,theName);
        }else{
            results = findAll();
        }

        return results;
    }
}
