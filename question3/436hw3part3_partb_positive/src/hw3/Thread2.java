package hw3;

public class Thread2 extends Thread {
	public void run() {
		try {
			Thread.sleep((long)Math.random()*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Main.x = Main.y;
	}
}
