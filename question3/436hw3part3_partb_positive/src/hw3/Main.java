package hw3;
// Serkan Özel // 2015400123 // serkan.ozel@boun.edu.tr
//CMPE436-Assignment 3
public class Main {
	
	static int x = 1;
	static int y = 4;
	
	public static void main(String[] args) throws InterruptedException {
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		
		System.out.println(Main.x);
		System.out.println(Main.y);
	}
	
	
	

}
