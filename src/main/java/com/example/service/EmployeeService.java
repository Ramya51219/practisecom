package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.entity.Employee;
import com.example.exception.EmployeeAlreadyExistsException;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeerepository;
	
	public Employee saveEmployee(Employee employee)throws EmployeeAlreadyExistsException{
		Employee excep=employeerepository.findById(employee.getId()).orElse(null);
		if(excep==null) {
			return employeerepository.save(employee);
			
		}else {
			throw new EmployeeAlreadyExistsException("Employee alredy exists");
			
		}
	}
	public List<Employee> saveEmployees(List<Employee>employees){
		return employeerepository.saveAll(employees);
	}
	public List<Employee>getEmployees(){
		return employeerepository.findAll(Sort.by("salary").descending().and(Sort.by("name")));
	}
	public Employee getEmployeeById(int id) {
		return employeerepository.findById(id).orElse(null);
	}
	
	public Employee getEmployeeByName(String name) {
		return employeerepository.findByName(name);
	}
	public String deleteEmployee(int id) {
		employeerepository.deleteById(id);
		return "employee is deleted"+id;
	}
	public Employee updateEmployee(Employee ep) {
		Employee em=employeerepository.findById(ep.getId()).orElse(null);
		em.setName(ep.getName());
		em.setSalary(ep.getSalary());
		em.setDesignation(ep.getDesignation());
		return employeerepository.save(em);
	}
	
	public String udateEmployeeBySalary(String salary,Employee employee) {
		employeerepository.save(employee);
		return "updated successfully" +salary;
	}

}

