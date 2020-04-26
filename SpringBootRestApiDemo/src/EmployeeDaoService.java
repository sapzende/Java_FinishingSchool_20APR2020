package com.capgemini.SpringBootDemo.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.capgemini.SpringBootDemo.Bean.Employee;

@Service
public class EmployeeDaoService {
	
		public static int usersCount=5;  
        private static List<Employee> empList=new ArrayList<>();
	    static{
		empList.add(new Employee(1, "sapana", "developer", 10000));
		empList.add(new Employee(2, "sager", "developer", 1000));
		empList.add(new Employee(3, "archana", "tester", 80000));
		empList.add(new Employee(4, "dipali", "developer", 50000));
		empList.add(new Employee(5, "sanjana", "developer", 10000));
	    }
		//method that retrieve all users from the list  
		public List<Employee> findAllEmpList()  
		{  
		return empList;  
		}  
		
		//method that retrive emp whose salary in between 40k to 80k
		
		public List<Employee>findEmpSalaryInBetween(){
			
			
			List<Employee> empListNew = empList.stream()  
	                .filter(s -> s.getSalary() < 80000 && s.getSalary() > 40000) //Multiple conditions
	                .collect(Collectors.toList());  
	 
			return empListNew;
		}
		
		public Employee findOne(int id){
			
			for(Employee emp:empList){
				if(emp.getId()==id){
					return emp;
				}
			}
			return null;
		}
		
		public Employee updateEmp(Employee emp,int id){
			
			Employee empnew=findOne(id);
			empnew.setId(emp.getId());
			empnew.setName(emp.getName());
			empnew.setDesignation(emp.getDesignation());
			empnew.setSalary(emp.getSalary());
			return empnew;
		}
		// method to post data
	public void saveEmp(Employee emp){
		
		 empList.add(emp);	
		
	}
	
	// method to delete data
	public Employee deleteById(int id)  
	{  
	Iterator<Employee> iterator = empList.iterator();  
	while(iterator.hasNext())  
	{  
		Employee emp=iterator.next();  
		if(emp.getId()==id)  
		{  
			iterator.remove();  
			return emp; //returns the deleted resource back  
		}  
	}  
	return null;  
	}  
}
