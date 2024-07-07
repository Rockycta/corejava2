package com.rocky.in;

public class WellWisher2 {
	
	public static void main(String[] args) {
		
		Greentings greentings=()->System.out.println("Hello");
		greentings.greet();
		
		Greentings EnglishGreetings=()->System.out.println("Greentings in English");
		EnglishGreetings.greet();
		
		Greentings HindiGreetings=()-> System.out.println("Greentings in Hindi");
		HindiGreetings.greet();

		WellWisher2 wellWisher = new WellWisher2();
		wellWisher.wish(greentings);
		wellWisher.wish(EnglishGreetings);
		wellWisher.wish(HindiGreetings);
	
	}

	public void wish(Greentings greet)
	{ 
		greet.greet(); 
	}
	
}
