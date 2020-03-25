package com.manny.springboot.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manny.springboot.crud.dzao.EmployeeRepository;
import com.manny.springboot.crud.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		this.employeeRepository = theEmployeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		List<Employee> employees = employeeRepository.findAllByOrderByLastNameAsc();
		
		
		return employees;
	}

	@Override
	public Employee findById(int id) {
		
		Optional<Employee> result = employeeRepository.findById(id);
		
		Employee theEmployee = null;
		
		if(result.isPresent() ){
			theEmployee = result.get();
		}else {
			throw new RuntimeException("Employee with is "+id+" was not found");
		}
		return theEmployee;
	}

	
	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
		
	}

	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}

}
