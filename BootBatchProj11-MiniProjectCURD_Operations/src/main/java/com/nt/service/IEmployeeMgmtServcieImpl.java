package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee;
import com.nt.repository.IEmployeeRepository;

@Service
public class IEmployeeMgmtServcieImpl implements IEmployeeMgmtServcie {
	@Autowired
	private IEmployeeRepository empRepository;

	@Override
	public List<Employee> getAllEmployees() {

		return empRepository.findAll();
	}

	@Override
	public String registerEmployee(Employee emp) {
		// Use Servcie
		int idVal = empRepository.save(emp).getEmpno();
		return "employee is saved with id value:" + idVal;
	}

	// In your service implementation
	@Override
	public Optional<Employee> getEmployeeById(int empno) {
		return empRepository.findById(empno);
	}

	// This method is now aligned with the POST /update request from the edit form
	@Override
	public Employee updateEmployeeById(Employee emp) {
		System.out.println("Updating employee: " + emp.getEmpno());
		Optional<Employee> opt = empRepository.findById(emp.getEmpno());
		if (opt.isPresent()) {
			Employee existingEmployee = opt.get();
			// Update the fields of the existing employee with the new values
			existingEmployee.setEname(emp.getEname());
			existingEmployee.setJob(emp.getJob());
			existingEmployee.setSal(emp.getSal());
			existingEmployee.setDeptno(emp.getDeptno());
			// Update other fields as necessary

			Employee updated = empRepository.save(existingEmployee);
			return updated;
		}
		return null; // Employee not found
	}

	@Override
	public String deleteEmployeeById(int empno) {
		if (empRepository.existsById(empno)) {
			empRepository.deleteById(empno);
			return "Employee with ID " + empno + " deleted successfully.";
		} else {
			return "Employee with ID " + empno + " not found.";
		}
	}

}
