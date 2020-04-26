package com.capgemini.SpringBootDemo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.SpringBootDemo.Bean.Employee;
import com.capgemini.SpringBootDemo.Service.EmployeeDaoService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeDaoService service;
	@GetMapping
	public String hello(){
		
		return "SringBoot Started Hello";
	}
	
	@GetMapping("/empList")  
	public List<Employee> retriveAllEmployee()  
	{  
	return service.findAllEmpList();  
	}  
	
	@GetMapping("/empList/{id}")
	public Employee getUser(@PathVariable int id){
		return service.findOne(id);
	}
	@GetMapping("/empListSalaryCondition")
	public List<Employee> getEmpList(){
		
		return service.findEmpSalaryInBetween();
		
	}
	
	@PostMapping("/empList")
	public String createEmployee(@RequestBody Employee emp){
		service.saveEmp(emp);
		return "Emp created successfully";
	}
	
	@DeleteMapping("/empDeleted/{id}")
	public String deleteEmp(@PathVariable int id){
		service.deleteById(id);
		return "Emp deleted";
	}
	
	@PutMapping("/empUpdted/{id}")
	public String updateEmp(@RequestBody Employee emp,@PathVariable int id){
		
		service.updateEmp(emp,id);
		return "Emp updated";
	}
}
