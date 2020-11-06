package com.example.spring.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.spring.mvc.model.Employee;
import com.example.spring.mvc.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value = "/getAllEmployees", method = RequestMethod.GET, headers = "Accept=application/json")
	 public String getEmployees(Model model) {
	  
	  List listOfEmployees = employeeService.getAllEmployees();
	  model.addAttribute("employee", new Employee());
	  model.addAttribute("listOfEmployees", listOfEmployees);
	  return "employeesDetails";
	 }
	
	@RequestMapping(value = "/getEmployees/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	 public Employee getEmployeeById(@PathVariable long id) {
	  return employeeService.getEmployee(id);
	 }
	
	 @RequestMapping(value = "/addEmployees", method = RequestMethod.POST, headers = "Accept=application/json")
	 public String addEmployee(@ModelAttribute("employee") Employee employee) { 
	  if(employee.getId()==0)
	  {
	   employeeService.addEmployee(employee);
	  }
	  else
	  { 
	   employeeService.updateEmployee(employee);
	  }
	  
	  return "redirect:/getAllEmployees";
	 }
	 
	 @RequestMapping(value = "/updateEmployees/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	 public String updateEmployee(@PathVariable("id") long id,Model model) {
	   model.addAttribute("employee", this.employeeService.getEmployee(id));
	         model.addAttribute("listOfEmployees", this.employeeService.getAllEmployees());
	         return "employeesDetails";
	 }
	 
	 @RequestMapping(value = "/deleteEmployees/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	 public String deleteEmployee(@PathVariable("id") long id) {
	  employeeService.deleteEmployee(id);
	   return "redirect:/getAllEmployees";
	 
	 } 

}
