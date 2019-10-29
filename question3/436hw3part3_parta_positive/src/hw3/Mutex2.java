package hw3;

public class Mutex2 {
boolean lock = true;
	
	
	public synchronized void getLock() {
		if(!lock){
			

			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
		}else {
			lock = false;
		}
	}
	
	
	public synchronized void releaseLock() {
		lock = true;
		this.notifyAll();
	}
}
