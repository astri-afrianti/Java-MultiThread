package MultiThreadClass;

public class ThreadDemo extends Thread{
	private Thread t;
	private String threadName;
	
	public ThreadDemo(String name) {
		this.threadName = name;
		System.out.printf("Creating Thread %s \n", threadName);
	}
	
	@Override
	public void run() {
		System.out.printf("Running Thread %s \n", threadName);
		try {
			for (int i = 4; i > 0; i--) {
				System.out.printf("Thread %s, %s \n", threadName, i);
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {
			System.out.printf("Thread %s interrupted: %s \n", threadName, e.getMessage());
		}
		
		System.out.printf("Thread %s exiting \n", threadName);
	}
	
	@Override
	public void start() {
		System.out.printf("Starting Thread %s \n", threadName);
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}
}
