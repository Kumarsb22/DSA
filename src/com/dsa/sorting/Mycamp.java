package com.dsa.sorting;

import java.util.Comparator;

public class Mycamp implements Comparator<Integer> {

	@Override
	public int compare(Integer a, Integer b) {
		return a % 2 - b % 2;
	}

}
