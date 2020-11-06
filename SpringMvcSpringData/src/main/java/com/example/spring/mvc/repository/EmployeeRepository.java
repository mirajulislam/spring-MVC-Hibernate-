package com.example.spring.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.mvc.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}