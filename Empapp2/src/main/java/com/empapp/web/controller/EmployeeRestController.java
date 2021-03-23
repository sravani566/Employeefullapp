package com.empapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empapp.config.AuthResponse;
import com.empapp.model.dao.Employee;
import com.empapp.model.service.EmployeeService;

//@CrossOrigin(origins = "*")
@CrossOrigin(origins = "http://localhost:4200")
@RestController //@Controller+@ResponseBody
public class EmployeeRestController {

	private EmployeeService employeeService;
	
	/*@PostConstruct
	public void init() {
		Employee e1=new Employee("raj", 40);
		Employee e2=new Employee("ekta", 38);
		employeeService.save(e1);
		employeeService.save(e2);
		
	}*/
	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	// ResponseEntity (GPP)= response + http status code
	@GetMapping("employee")
	public ResponseEntity<List<Employee>> getAllEmp(){
		List<Employee> employees=employeeService.getAll();
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}
	@GetMapping(path="employee/{id}")
	public Employee getEmployeeById(@PathVariable(name="id") int empId) {
		Employee employee= employeeService.getEmployeeById(empId);
		return employee;
	}
	
	//post operation
	@PostMapping(path="employee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) {
		Employee employee2=employeeService.save(emp);
		return new ResponseEntity<Employee>(employee2, HttpStatus.CREATED);
	}
	
	//update
	@PutMapping(path="employee/{id}")
	public Employee updateEmployee(@RequestBody Employee emp, @PathVariable(name="id") int empId) {
		Employee employee= employeeService.update(empId, emp);
		return employee;
	}
	
	//delete
	@DeleteMapping(path="employee/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Employee deleteEmployee(@PathVariable(name="id") int empId) {
		Employee employee= employeeService.delete(empId);
		return employee;
	}
	@GetMapping(produces = "application/json")
	@RequestMapping({ "/validateLogin" })
	public AuthResponse validateLogin() {
			return new AuthResponse("User successfully authenticated");
	}
	
}






