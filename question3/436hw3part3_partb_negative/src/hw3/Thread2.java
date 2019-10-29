package hw3;

public class Thread2 extends Thread {
	
	Mutex m;
	
	public Thread2(Mutex m) {
		this.m = m;
	}
	
	public void run() {
		try {
			Thread.sleep((long)Math.random()*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			m.getLock();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Main.x = Main.y;
		try {
			m.returnLock();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
