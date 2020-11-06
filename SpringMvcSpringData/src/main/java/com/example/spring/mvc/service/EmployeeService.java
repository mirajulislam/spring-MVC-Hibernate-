package com.example.spring.mvc.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring.mvc.model.Employee;
import com.example.spring.mvc.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository  employeeRepository;
	
	 @Transactional
	 public List getAllEmployees() {
	  List employees=new ArrayList();
	  Iterable employeesIterable=employeeRepository.findAll();
	  Iterator employeesIterator=employeesIterable.iterator();
	  while(employeesIterator.hasNext())
	  {
	   employees.add(employeesIterator.next());
	  }
	  return employees;
	 }
	 
	 @Transactional
	 public Employee getEmployee(long id) {
	  return employeeRepository.findOne((long) id);
	 }
	 
	 @Transactional
	 public void addEmployee(Employee employee) {
	  employeeRepository.save(employee);
	 }
	 
	 @Transactional
	 public void updateEmployee(Employee employee) {
	  employeeRepository.save(employee);
	 
	 }
	 
	 @Transactional
	 public void deleteEmployee(long id) {
	  employeeRepository.delete(id);
	 }

}
