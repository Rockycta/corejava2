package com.rocky3.in;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateEx {

	
	public static void main(String[] args) {
	
		
		 Employee employee1 = new Employee(5,"Rakesh",7000);
		 Employee employee2 = new Employee(2,"Mukesh",5000);
		 Employee employee3 = new Employee(4,"Rajesh",6000);
		 Employee employee4 = new Employee(3,"Sailesh",9000);
		 Employee employee5 = new Employee(8,"Shankar",2000);

		 
		List<Employee> list = Arrays.asList(employee1,employee2,employee3,employee4,employee5);

		for (Employee employee : list) {
			
			Predicate<Employee> p = e -> e.salary>5000;
		 	if(p.test(employee)==true)
		 		System.out.println(employee.getName()+"-->"+employee.getSalary());
		 	
		}
	}	
}
