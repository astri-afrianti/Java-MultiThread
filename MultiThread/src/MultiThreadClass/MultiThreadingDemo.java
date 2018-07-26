package MultiThreadClass;

public class MultiThreadingDemo extends Thread {
	@Override
	public void run() {
		try {
			// Displaying the thread that running
			System.out.printf("Thread %s is running \n", Thread.currentThread().getId());
		}
		catch(Exception e) {
			System.out.printf("Exception %s is caught \n", e.getMessage());
		}
	}
}
