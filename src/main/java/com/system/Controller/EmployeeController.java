package com.system.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.system.Entity.Employee;
import com.system.Exception.ResourceNotFoundEXception;
import com.system.Service.EmployeeService;

@RestController
@RequestMapping("employee")
@CrossOrigin("*")
public class EmployeeController {
	@Autowired 
	private EmployeeService employeeService;
	
	@PostMapping("addemployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp){
		Employee employee=employeeService.addEmployee(emp);
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	@GetMapping("getAllEmployees")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> employee=employeeService.getAllEmployees();
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
    @GetMapping("getById/{id}")
    public ResponseEntity<Employee> getById(@PathVariable long id) throws ResourceNotFoundEXception{
    	Optional<Employee> employee=employeeService.getById(id);
    	if(employee.isPresent()) {
    	return  new ResponseEntity<>(employee.get(),HttpStatus.OK);
    	}
    	else {
    		throw new ResourceNotFoundEXception("Employee with "+id+" is not found");
    	}
    }
    @PutMapping("updateById/{id}")
    public ResponseEntity<Employee> updateById(@PathVariable long id,@RequestBody Employee emp)throws ResourceNotFoundEXception{
    	Optional<Employee> employee=employeeService.getById(id);
    	if(employee.isPresent()) {
    	emp.seteId(id);
    	Employee employ=employeeService.updateById(emp);
    	return new ResponseEntity<>(employ,HttpStatus.OK);
    	}
    	else {
    		throw new ResourceNotFoundEXception("Employee with "+id+" is not found");
    	}
    }
    @DeleteMapping("deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id)throws ResourceNotFoundEXception{
    	Optional<Employee> employee=employeeService.getById(id);
    	if(employee.isPresent()) {
    	employeeService.deleteEmployeeById(id);
    	return ResponseEntity.noContent().build();
    	}
    	else {
    		throw new ResourceNotFoundEXception("Employee with "+id+" is not found");
    	}
    }
}
