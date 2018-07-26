package MainApp;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import Concurrency.*;

public class ConcurrencyMainApp {		
	public static void main(final String[] args) {
		Path testDir = Paths.get("E:\\CDC\\Java Bootcamp\\Project\\Java-MultiThread");
		
		System.out.println("==================================================");
		System.out.println("Single Thread");		
		final long start = System.nanoTime();
	    final long size = SingleThreadDirSize.sizeOf(testDir.toFile());
	    final long taken = System.nanoTime() - start;
	    
	    System.out.printf("Size of '%s': %s bytes %s nano (in %s second) \n", testDir.toFile(), size, taken, TimeUnit.NANOSECONDS.toSeconds(taken));
	    
	    System.out.println("==================================================");
		System.out.println("Recursive Task Thread");
		final long recursiveTaskStart = System.nanoTime();
	    final long recursiveTaskSize = RecursiveTaskDirSize.sizeOf(testDir.toFile());
	    final long recursiveTaskTaken = System.nanoTime() - recursiveTaskStart;
	    
	    System.out.printf("Size of '%s': %s bytes %s nano (in %s second) \n", testDir.toFile(), recursiveTaskSize, recursiveTaskTaken,TimeUnit.NANOSECONDS.toSeconds(recursiveTaskTaken));
	    
	    System.out.println("==================================================");
		System.out.println("Executor Thread");
		final long executorStart = System.nanoTime();
	    final long executorSize = ExecutorServiceDirSize.sizeOf(testDir.toFile());
	    final long executorTaken = System.nanoTime() - executorStart;
	    
	    System.out.printf("Size of '%s': %s bytes %s nano (in %s second) \n", testDir.toFile(), executorSize, executorTaken,TimeUnit.NANOSECONDS.toSeconds(executorTaken));
	}
}
