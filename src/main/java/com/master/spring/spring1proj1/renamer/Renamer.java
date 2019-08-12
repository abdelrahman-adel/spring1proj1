package com.master.spring.spring1proj1.renamer;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Component;

@Component
public class Renamer {

	private static final String FIX_TO_REMOVE = "-subtitle-en";

	public void renameFiles(String path) {
		System.out.println("Receiving path: " + path);
		renameRecursively(new File(path));
	}

	private void renameRecursively(File directory) {
		System.out.println("Scanning path ..\n");
		File[] paths = directory.listFiles();
		for (File file : paths) {
//			File file = new File(path);
			if (file.isDirectory()) {
				System.out.println("Directory found: " + file);
				renameRecursively(file);
			} else if (file.getName().endsWith(".vtt") || file.getName().endsWith(".srt")) {
				System.out.println("File found: " + file);
				renameFile(file);
			}
		}
	}

	private void renameFile(File file) {
		try {
			String newName = file.getCanonicalPath().replace(FIX_TO_REMOVE, "");
			System.out.println("Renaming to: " + newName);
			if (file.renameTo(new File(newName))) {
				System.out.println("Renaming succedded ..");
			}
		} catch (IOException e) {
			System.err.println("File was not renamed: " + file);
			e.printStackTrace();
		}
	}
}
