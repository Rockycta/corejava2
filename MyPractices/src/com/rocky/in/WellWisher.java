package com.rocky.in;

public class WellWisher {
	
	public static void main(String[] args) {
		
		Greentings greentings=()->System.out.println("Hello");
		greentings.greet();
		wish(greentings);
	
		Greentings EnglishGreetings=()->System.out.println("Greentings in English");
		EnglishGreetings.greet();
		
		Greentings HindiGreetings=()-> System.out.println("Greentings in Hindi");
		HindiGreetings.greet();
					
		
	}

	
	  public void wish(Greentings greet)
	  { 
		  greet.greet(); 
	  }
	 
}
