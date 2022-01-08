package com.example.springboot.thymeleafdemo.dao;

import com.example.springboot.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeReposiptory extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL.

    // Create free CRUD feature for you

    // add a method to sort by last name
    public List<Employee> findAllByOrderByLastNameAsc();

    // search
    public List<Employee> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String name, String lName);
}
