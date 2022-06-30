package com.multithreading.ex1;

public class Test07 {

	public static void main(String[] args) throws InterruptedException{
		
		MyThread mt = new MyThread();
		Thread.State state = mt.getState();
		System.out.println(state);
	
		mt.start();
		System.out.println(mt.getState());
		
		Thread.sleep(1000);
		System.out.println(mt.getState());
		
		Thread.sleep(10000);
		System.out.println(mt.getState());
	}	
}
