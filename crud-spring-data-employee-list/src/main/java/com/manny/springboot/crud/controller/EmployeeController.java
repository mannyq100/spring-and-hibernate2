package com.manny.springboot.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.manny.springboot.crud.entity.Employee;
import com.manny.springboot.crud.service.EmployeeServiceImpl;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeServiceImpl employeeService;
	
	@Autowired
	public EmployeeController(EmployeeServiceImpl theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	
	@GetMapping("/list")
	public String employeeList(Model theModel) {
		List<Employee> employees = employeeService.findAll();
		
		theModel.addAttribute("employee", employees);
		
	
		return "employees/employee-list";		
	}
	
	@GetMapping("/showFormForAdd")
	public String showformForAdd(Model theModel) {
		Employee theEmployee = new Employee();
		
		theModel.addAttribute("employee", theEmployee);
		
		return "employees/show-form";
		
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		employeeService.save(theEmployee);
		
		return "redirect:/employees/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theid, Model themodel) {
		Employee theEmployee = employeeService.findById(theid);
		
		themodel.addAttribute("employee", theEmployee);
		
		return "employees/show-form";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {
				employeeService.deleteById(theId);
		
		return "redirect:/employees/list";
		
	}

}
