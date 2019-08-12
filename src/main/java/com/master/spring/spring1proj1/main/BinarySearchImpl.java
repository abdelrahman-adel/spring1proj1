package com.master.spring.spring1proj1.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {
	
	@Autowired
	private SortAlgorithm sortAlgorithm;

	public SortAlgorithm getSortAlgorithm() {
		return sortAlgorithm;
	}

	public void setSortAlgorithm(SortAlgorithm sortAlgorithm) {
		this.sortAlgorithm = sortAlgorithm;
	}

	public int binarySearch(int[] numbers, int numToSearchFor) {
		sortAlgorithm.sort(numbers);
		System.out.println(sortAlgorithm);
		
		//search logic
		return 2;
	}
}
