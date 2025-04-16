package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.entity.Employee;

public interface IEmployeeMgmtServcie {

	public List<Employee> getAllEmployees();

	public String registerEmployee(Employee emp);

	Optional<Employee> getEmployeeById(int empno);

	Employee updateEmployeeById(Employee emp);

	public String deleteEmployeeById(int empno);
}
