package hw3;

public class Mutex {

	static boolean lock = false;
	
	
	public synchronized void getLock() throws InterruptedException {
		if(!lock)this.wait();
		else {
			lock = false;
		}
	}
	
	public synchronized void returnLock() throws InterruptedException {
		lock = true;
		this.notifyAll();
	}
}
