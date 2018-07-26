package Concurrency;

import java.io.File;
import java.util.*;
import java.util.Objects;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class RecursiveTaskDirSize {
	
	private static class SizeOfFileTask extends RecursiveTask<Long>{
		private static final long serialVersionUID = -196522408291343951L;
		private final File file;
		
		public SizeOfFileTask(final File file) {
			this.file = Objects.requireNonNull(file);
		}
		
		@Override
		protected Long compute() {		
			System.out.println("Computing size of " + file);
			
			if(file.isFile()) {
				return file.length();
			} 
			
			final ArrayList<SizeOfFileTask> tasks = new ArrayList<>();
			final File[] children = file.listFiles();
			
			if (children != null) {
				for (final File child : children) {
					final SizeOfFileTask task = new SizeOfFileTask(child);
					task.fork();
					tasks.add(task);
				}
			}
			
			long size = 0;
			for (final SizeOfFileTask task : tasks) {
				size += task.join();
			}
			
			return size;			
		}		
		
	}
	
	public static long sizeOf(final File file) {
		final ForkJoinPool pool = new ForkJoinPool();
		
		try {
			return pool.invoke(new SizeOfFileTask(file));
		} finally {
			pool.shutdown();
		}
	}
	
	private RecursiveTaskDirSize() {}
}
