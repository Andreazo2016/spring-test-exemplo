package com.devman.testExemplo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeController {

	@PostMapping(value = "/employees")
	public ResponseEntity<Employee> addEmployee (@RequestBody Employee employee)
	{
	    //code
	    return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
	}
	@GetMapping(value = "/employees")
	public @ResponseBody EmployeeListDTO getAllEmployees()
	{
	    List<Employee> employees = new ArrayList<>();
	    employees.add( new Employee("Julio Blestrin") );
	    employees.add( new Employee("Paulo Muzy") );
	    employees.add( new Employee("Vilão") );
	    
	    EmployeeListDTO em = new EmployeeListDTO();
	    em.setEmployees( employees );
	    return em;
	}
	 
	@GetMapping(value = "/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById (@PathVariable("id") int id)
	{
	    return new ResponseEntity<>( new Employee("Vilão"), HttpStatus.OK );
	}
	
	@PutMapping(value = "/employees/{id}")
	public ResponseEntity<Employee> updateEmployee (@PathVariable("id") int id, @RequestBody Employee employee)
	{
	    //code
	    return new ResponseEntity<Employee>(new Employee("João"), HttpStatus.OK);
	}
}
