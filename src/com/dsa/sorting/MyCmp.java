package com.dsa.sorting;

import java.util.Comparator;

public class MyCmp implements Comparator<Points> {

	@Override
	public int compare(Points o1, Points o2) {
		return o1.x - o2.x;
	}

}
