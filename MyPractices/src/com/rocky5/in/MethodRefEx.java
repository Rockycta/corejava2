package com.rocky5.in;

public class MethodRefEx {

	public static void main(String[] args) {
		
		Interf f = ()->System.out.println("Hello");
		f.m1();
		
		Interf f1 = MethodRefEx::m2;
		f1.m1();

		MethodRefEx mr = new MethodRefEx();
		Interf f2 = mr::m3;
		f2.m1();
	}
	
	static void m2() {
		for(int i=0;i>10;i++)
			System.out.println("i"+i);
	}
	
	 	void m3() {
		System.out.println("It is instance method");
	}
	
	
}

