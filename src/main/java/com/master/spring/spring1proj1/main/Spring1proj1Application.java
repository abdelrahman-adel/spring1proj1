package com.master.spring.spring1proj1.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Spring1proj1Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(Spring1proj1Application.class, args);
		BinarySearchImpl binarySearchImpl = applicationContext.getBean(BinarySearchImpl.class);
		
		int result = binarySearchImpl.binarySearch(new int[] {1, 2, 3}, 2);
		System.out.println(result);
	}

}
