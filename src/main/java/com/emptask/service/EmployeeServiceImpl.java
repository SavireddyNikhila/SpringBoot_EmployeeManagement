package com.emptask.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emptask.entity.Employee;
import com.emptask.exception.EmployeeNotFoundException;
import com.emptask.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee AddEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> listEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee fetchemployeeById(Long employeeId) throws EmployeeNotFoundException {
		Optional<Employee> emp = employeeRepository.findById(employeeId);
		if (!emp.isPresent()) {
			throw new EmployeeNotFoundException("Employee not found with the given Id : " + employeeId);
		}
		return emp.get();
	}

	@Override
	public Employee updateEmployeeById(Long employeeId, Employee employee) throws EmployeeNotFoundException {
		Optional<Employee> emp = employeeRepository.findById(employeeId);
		if (!emp.isPresent())
			throw new EmployeeNotFoundException("Employee Not Found with the given Id:" + employeeId);
		else {
			Employee empDB = employeeRepository.findById(employeeId).get();
			if (Objects.nonNull(employee.getFirstName()) && !"".equalsIgnoreCase(employee.getFirstName())) {
				empDB.setFirstName(employee.getFirstName());
			}
			if (Objects.nonNull(employee.getLastName()) && !"".equalsIgnoreCase(employee.getLastName())) {
				empDB.setLastName(employee.getLastName());
			}
			if (Objects.nonNull(employee.getEmail()) && !"".equalsIgnoreCase(employee.getEmail())) {
				empDB.setEmail(employee.getEmail());
			}
			if (Objects.nonNull(employee.getPhone()) && !"".equalsIgnoreCase(employee.getPhone())) {
				empDB.setPhone(employee.getPhone());
			}
			if (Objects.nonNull(employee.getDob())) {
				empDB.setDob(employee.getDob());
			}
			if (Objects.nonNull(employee.getImage()) && !"".equalsIgnoreCase(employee.getImage())) {
				empDB.setImage(employee.getImage());
			}
			return employeeRepository.save(empDB);
		}
	}

	@Override
	public void deleteEmployeeById(Long employeeId) throws EmployeeNotFoundException {
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		if (!employee.isPresent())
			throw new EmployeeNotFoundException("Employee Not Found with the given Id:" + employeeId);
		else
			employeeRepository.deleteById(employeeId);

	}
}
