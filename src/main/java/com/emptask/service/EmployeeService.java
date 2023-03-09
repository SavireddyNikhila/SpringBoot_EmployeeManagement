package com.emptask.service;

import java.util.List;

import com.emptask.entity.Employee;
import com.emptask.exception.EmployeeNotFoundException;

public interface EmployeeService {

	public Employee AddEmployee(Employee employee);

	public List<Employee> listEmployees();

	public Employee fetchemployeeById(Long employeeId) throws EmployeeNotFoundException;

	public Employee updateEmployeeById(Long employeeId,Employee employee) throws EmployeeNotFoundException;

	public void deleteEmployeeById(Long employeeId) throws EmployeeNotFoundException;

}
