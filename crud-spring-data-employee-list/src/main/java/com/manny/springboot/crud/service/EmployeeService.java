package com.manny.springboot.crud.service;

import java.util.List;

import com.manny.springboot.crud.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int id);
}
