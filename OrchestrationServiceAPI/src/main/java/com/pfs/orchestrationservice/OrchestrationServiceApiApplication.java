package com.pfs.orchestrationservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class OrchestrationServiceApiApplication {

	List<EmployeeVO> listOfEmployees = new ArrayList<>();
	
	public static void main(String[] args) {
		SpringApplication.run(OrchestrationServiceApiApplication.class, args);
	}

	@RequestMapping(value = "/employee/{employeeId}", method = RequestMethod.GET)
	public ResponseEntity<Object> getEmployeeDetails(@PathVariable String employeeId) {
		EmployeeVO employeeDtl = getEmployeeDtl(employeeId);
		if(employeeDtl==null) {
			return new ResponseEntity<Object>("EmployeeId is not available in "
					+ "Organization Database",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(employeeDtl,HttpStatus.OK);
	}

	@RequestMapping(value = "/employee/add",method = RequestMethod.POST)
	public ResponseEntity<Object> addEmployeeDetails(@RequestBody EmployeeVO employee) {
		listOfEmployees.add(employee);
		return new ResponseEntity<Object>("Employee is added Successfully",HttpStatus.CREATED);
		
	}

	private EmployeeVO getEmployeeDtl(String employeeId) {
		EmployeeVO employee = null;
		for(EmployeeVO empl:listOfEmployees) {
			if(employeeId.equals(empl.getEmployeeId())) {
				employee = empl;
			}
		}
		return employee;
	}
	
}
