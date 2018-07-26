package MultiThreadClass;

public class RunnableDemo implements Runnable {
	private Thread t;
	private String threadName;
	
	public RunnableDemo (String name){
		threadName = name;
		System.out.printf("Creating %s \n", threadName);
	}
	
	public void run() {
		System.out.printf("Running %s \n", threadName);
		try {
			for (int i = 4; i > 0; i--) {
				System.out.printf("Thread: %s, %s \n", threadName, i);
				// Let the thread sleep for a while
				Thread.sleep(50);
			}
		}
		catch (InterruptedException e) {
			System.out.printf("Thread: %s interrupted \n", threadName);
		}
		System.out.printf("Thread: %s exitting \n", threadName);
	}
	
	public void start() {
		System.out.printf("Starting %s \n", threadName);
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}
}
