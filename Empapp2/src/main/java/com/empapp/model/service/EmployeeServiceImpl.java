package com.empapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.empapp.model.dao.EmpRepo;
import com.empapp.model.dao.Employee;
import com.empapp.model.dao.EmployeeNotFoundException;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmpRepo empRepo;
	
	@Override
	public List<Employee> getAll() {
		return (List<Employee>) empRepo.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee employee=empRepo.findById(id).orElseThrow(()->new EmployeeNotFoundException("Event Details are not there"));
		return employee;
	}

	@Override
	public Employee save(Employee emp) {
		return empRepo.save(emp);
	}

	@Override
	public Employee delete(int empId) {
		Employee employeeToDelete=getEmployeeById(empId);
		empRepo.delete(employeeToDelete);
		return employeeToDelete;
	}

	@Override
	public Employee update(int empId, Employee emp) {
		Employee employeeToUpdate=getEmployeeById(empId);
		employeeToUpdate.setName(emp.getName());
		employeeToUpdate.setAge(emp.getAge());
		return empRepo.save(employeeToUpdate);
	}
}


