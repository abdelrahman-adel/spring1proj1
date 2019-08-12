package com.master.spring.spring1proj1.main;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.master.spring.spring1proj1.renamer.Renamer;
import com.master.spring.spring1proj1.res.BinarySearchImpl;

/*
 * This annotation @ComponentScan has an attribute 'basePackages'
 * that takes array of strings representing packages to scan
 */
@ComponentScan(basePackages = { "com.master.spring.spring1proj1.res", "com.master.spring.spring1proj1.renamer" })
@SpringBootApplication
public class Spring1proj1Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(Spring1proj1Application.class, args);
		BinarySearchImpl binarySearchImpl = applicationContext.getBean(BinarySearchImpl.class);

		int result = binarySearchImpl.binarySearch(new int[] { 1, 2, 3 }, 2);
		System.out.println(result);

		System.out.println("\n\n");

		System.out.print("Enter the path you want to rename files in: ");
		Scanner consoleInput = new Scanner(System.in);
		String path = consoleInput.nextLine();
		consoleInput.close();

		System.out.println("You entered: " + path);
		System.out.println("Renaming in progress ..");

		Renamer renamer = applicationContext.getBean(Renamer.class);
		renamer.renameFiles(path);
		
		System.out.println("Renaming finished successfully!!");
	}

}
