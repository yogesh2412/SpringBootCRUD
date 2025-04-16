package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nt.entity.Employee;
@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

}
