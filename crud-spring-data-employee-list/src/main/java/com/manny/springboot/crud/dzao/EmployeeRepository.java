package com.manny.springboot.crud.dzao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.manny.springboot.crud.entity.Employee;

// @RepositoryRestResource(path="members") cant be used to change name of endpoint
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	
	public List<Employee> findAllByOrderByLastNameAsc();
}
