package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.exception.EmployeeAlreadyExistsException;
import com.example.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	@PostMapping("/employeez")
	public Employee addEmployee(@RequestBody Employee employee) throws EmployeeAlreadyExistsException{
		return service.saveEmployee(employee);
	}
	@PostMapping("/employees")
	public List<Employee> addEmployees(@RequestBody List<Employee> employees){
		return service.saveEmployees(employees);
	}
	@GetMapping("/employeez")
	public List<Employee> findAllEmployees(){
		return service.getEmployees();
	}
	@GetMapping("/find1/{id}")
	public Employee findEmployeeById(@PathVariable int id) {
		return service.getEmployeeById(id);
	}
	@GetMapping("/find2/{name}")
	public  Employee findEmployeeByName(@PathVariable String name) {
		return service.getEmployeeByName(name);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return  service.deleteEmployee(id);
	}

}

