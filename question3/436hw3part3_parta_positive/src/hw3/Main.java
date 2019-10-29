package hw3;
// Serkan Özel // 2015400123 // serkan.ozel@boun.edu.tr
//CMPE436-Assignment 3
public class Main {

	static int staticVar = 1;
	public static void main(String[] args) throws InterruptedException {
		int x,y,z;
		x = 2;
		y = 3;
		z = 4;
		
		Mutex m = new Mutex();
		Mutex2 m2 = new Mutex2();
		
		Thread1 t1 = new Thread1(m,m2,x,y,z);
		Thread1 t2 = new Thread1(m,m2,x,y,z);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		

	}

}
