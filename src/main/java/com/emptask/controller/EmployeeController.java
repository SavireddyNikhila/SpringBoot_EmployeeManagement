package com.emptask.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emptask.entity.Employee;
import com.emptask.exception.EmployeeNotFoundException;
import com.emptask.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/employee")
	public Employee AddEmployee(@Valid @RequestBody Employee employee) {
		return employeeService.AddEmployee(employee);
	}

	@GetMapping("/list/employees")
	public List<Employee> listEmployees() {
		return employeeService.listEmployees();
	}

	@GetMapping("/getemployee/{id}")
	public Employee fetchEmployeeById(@PathVariable("id") Long employeeId) throws EmployeeNotFoundException {
		return employeeService.fetchemployeeById(employeeId);
	}

	@PutMapping("/updateemployee/{id}")
	public Employee updateEmployeeById(@PathVariable("id") Long employeeId, @RequestBody Employee employee)
			throws EmployeeNotFoundException {
		return employeeService.updateEmployeeById(employeeId, employee);
	}

	@DeleteMapping("/deleteemployee/{id}")
	public String deleteEmployeeById(@PathVariable("id") Long employeeId) throws EmployeeNotFoundException {
		employeeService.deleteEmployeeById(employeeId);
		return "Employee with Id :" + employeeId + " deleted successfully";
	}
}
