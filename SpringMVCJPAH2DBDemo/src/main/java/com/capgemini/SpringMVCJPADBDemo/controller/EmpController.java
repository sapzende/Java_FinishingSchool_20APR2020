package com.capgemini.SpringMVCJPADBDemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.SpringMVCJPADBDemo.Entity.Employee;
import com.capgemini.SpringMVCJPADBDemo.Exceptions.RecordNotFoundException;
import com.capgemini.SpringMVCJPADBDemo.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmpController {

	@Autowired
    EmployeeService service;
	
	@GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> list = service.getAllEmployees();
 
        return new ResponseEntity<List<Employee>>(list, new HttpHeaders(), HttpStatus.OK);
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id) 
                                                    throws RecordNotFoundException {
        Employee entity = service.getEmployeeById(id);
 
        return new ResponseEntity<Employee>(entity, new HttpHeaders(), HttpStatus.OK);
    }
	
	 @PostMapping
	    public ResponseEntity<Employee> createOrUpdateEmployee(@RequestBody Employee employee)
	                                                    throws RecordNotFoundException {
	        Employee updated = service.createOrUpdateEmployee(employee);
	        return new ResponseEntity<Employee>(updated, new HttpHeaders(), HttpStatus.OK);
	    }
	
	@DeleteMapping("/{id}")
    public HttpStatus deleteEmployeeById(@PathVariable("id") Integer id) 
                                                    throws RecordNotFoundException {
        service.deleteEmployeeById(id);
        return HttpStatus.FORBIDDEN;
    }
}
