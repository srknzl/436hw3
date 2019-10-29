package hw3;

public class Thread1 extends Thread {
	
	Mutex m;
	
	public Thread1(Mutex m) {
		this.m = m;
	}
	
	public void run() {
		try {
			Thread.sleep((long)Math.random()*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Main.y = Main.x;
		try {
			m.returnLock();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
