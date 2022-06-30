package com.multithreading.ex1;

public class MyThread extends Thread{

	public void run() {
		//System.out.println(mt.getState()); 
		//mt variable not defined here.
		System.out.println(getState());
		System.out.println(this.getState());
		
		try {
			sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
