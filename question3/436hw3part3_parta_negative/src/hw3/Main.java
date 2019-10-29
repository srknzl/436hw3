package hw3;
// Serkan Özel // 2015400123 // serkan.ozel@boun.edu.tr
//CMPE436-Assignment 3
public class Main {
	public static void main(String[] args) throws InterruptedException {		
		
		Thread1 t1 = new Thread1();
		Thread1 t2 = new Thread1();
		
		t1.setName("Thread 1");
		t2.setName("Thread 2");
		
		t1.start();
		t2.start();
		
		
		t1.join();
		t2.join();
		
		
	}

}
