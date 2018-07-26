package Concurrency;

import java.io.File;

public class SingleThreadDirSize {
	
	public static long sizeOf(final File file) {
		System.out.println("Computing size of: " + file);
		long size = 0;
		
		// ignore files which are not files and dirs
		if (file.isFile()) {
			size = file.length();
		} else {			
			final File[] children = file.listFiles();
			if (children != null) {
				for(final File child : children) {
					size += RecursiveTaskDirSize.sizeOf(child);
				}
			}
		}
		
		return size;
	}
}
