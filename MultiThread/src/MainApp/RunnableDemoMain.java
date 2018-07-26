package MainApp;

import MultiThreadClass.*;

public class RunnableDemoMain {

	public static void main(String[] args) {
		RunnableDemo runableDemo1 = new RunnableDemo("Thread 1");
		runableDemo1.start();
		
		RunnableDemo runableDemo2 = new RunnableDemo("Thread 2");
		runableDemo2.start();
		
		ThreadDemo demo1 = new ThreadDemo("Thread 1");
		demo1.start();
		
		ThreadDemo demo2 = new ThreadDemo("Thread 2");
		demo2.start();
	}

}
