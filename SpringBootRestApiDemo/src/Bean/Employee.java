package com.capgemini.SpringBootDemo.Bean;

import org.springframework.stereotype.Component;


public class Employee {
	
	private Integer id;
	private String name;
	private String Designation;
	private Integer Salary;
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public Integer getSalary() {
		return Salary;
	}
	public void setSalary(int salary) {
		Salary = salary;
	}
	public Employee(Integer id, String name, String designation, Integer salary) {
		super();
		this.id = id;
		this.name = name;
		Designation = designation;
		Salary = salary;
	}
	public Employee() {
		
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", Designation="
				+ Designation + ", Salary=" + Salary + "]";
	}
	
	

}
