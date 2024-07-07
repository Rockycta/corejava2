package com.rocky2.in;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingObjects {

	public static void main(String[] args) {
		
	//	new Person(1,"Rakesh",35);
		
	/*
	 * Person person = new Person(); Person person2 = new Person(); Person person3 =
	 * new Person();
	 * 
	 */
		
	Person person0 = new Person(1, "Rakesh", 35);
	Person person1 = new Person(4, "Sreya", 29);
	Person person2 = new Person(2, "Kanmani", 40);
	Person person3 = new Person(3, "Chinmini",25);
	
	 List<Person> list = new ArrayList<Person>();
	 list.add(person0);
	 list.add(person1);
	 list.add(person2);
	 list.add(person3);
	

	 Collections.sort(list,new PersonComparator());
	 System.out.println(list);
	 
	 list.stream().forEach(p->System.out.println(p.getName()));
	 
	 System.out.println("======Using lambda=======");
	 
	 Collections.sort(list,(p1,p2)->{
		 
		 return p1.getName().compareTo(p2.getName());
	 });
	 
	 list.stream().forEach(p->System.out.println(p.getName()));

	}
}
