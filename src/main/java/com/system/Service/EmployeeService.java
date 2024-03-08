package com.system.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.Entity.Employee;
import com.system.Repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired 
	private EmployeeRepository employeeRepo;
	
	public Employee addEmployee(Employee emp) {
		return employeeRepo.save(emp);
	}
	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}
	public Optional<Employee> getById(long id) {
		return employeeRepo.findById(id);
	}
	public Employee updateById(Employee emp) {
		Optional<Employee> updateEmp=employeeRepo.findById(emp.geteId());
		if(updateEmp.isPresent()) {	
			Employee existingEmployee=updateEmp.get();
		    existingEmployee.setFirstName(emp.getFirstName());
		    existingEmployee.setLastName(emp.getLastName());
		    existingEmployee.setContactNo(emp.getContactNo());
		    existingEmployee.setEmailId(emp.getEmailId());
		    return employeeRepo.save(existingEmployee);
		}
		else {
			return emp;
		}
	}
	public Optional<Employee> deleteEmployeeById(long id) {
		return employeeRepo.deleteById(id);
	}
}
