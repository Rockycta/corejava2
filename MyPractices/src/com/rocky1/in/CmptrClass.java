package com.rocky1.in;

import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class CmptrClass implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		
		if(o1 > o2) {
			
		}
		
		
		
		int val1 = (int)o1;
		int val2 = (int)o2;
		if(val1 > val2) {
			return -1;
		}
		else if(val1<val2){
		return 1;
		}
		
		else return 0;
		// TODO Auto-generated method stub
				
		
		
		
		}
	}

	

