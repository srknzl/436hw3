package hw3;


public class Thread1 extends Thread {
	
	Mutex m;
	Mutex2 m2;
	int x,y,z;
	
	public Thread1(Mutex m, Mutex2 m2, int x, int y, int z) {
		this.m = m;
		this.m2 = m2;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void run() {
		
		m2.getLock();
		Main.staticVar--;	
		m2.releaseLock();
		System.out.println(Main.staticVar);
		m.getLock();
		System.out.println(Main.staticVar);
		Main.staticVar++;	
		m.releaseLock();
		
	}

}
