package com.rocky2.in;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {

	
	@Override
	public int compare(Person p1, Person p2) {
		// TODO Auto-generated method stub
		return p2.getName().compareTo(p1.getName());
		
		//return 1;
	}

	
	
}
