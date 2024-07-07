package com.rocky1.in;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class SortingExample {

	public static void main(String[] args) {
		
		 ArrayList <Integer> list = new ArrayList<>();
		 
		// HashMap<K, V>
	
		 list.add(10);
		 list.add(50);
		 list.add(20);
		 list.add(40);
		 list.add(30);
		 
		 Collections.sort(list);
		// System.out.println(list);
		 
		 @SuppressWarnings("unchecked")
		Comparator<Integer> comparator = new CmptrClass();	
	//	 Collections.sort(list,comparator);
	
		
		 
		 //My doubt is, is it sorting directly the values inside in the list?
		 //by code, that is how it is, because we are not storing the results 
		 //in any object and printing.
		 /* so, understand that in the List itself, values or objects will
		  * be sorted.*/
		 System.out.println(list);
		 
		 
		 /* There is one doubt, when I tried to use direct object o1 in 
		  * cmptrClass it didn't work, but while using in Lambda,it 
		  * is working. Identify how it is.
		  * */
		 
		 Collections.sort(list,(o1,o2)->{
			 return (o1>o2)?-1:(o1<o2)?1:0;
			 
		 });
		 
		 
		 System.out.println(list);
	}
	
	
}
