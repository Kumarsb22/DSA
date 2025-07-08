package com.dsa.sorting;

import java.util.Arrays;

public class Sort5Problem {
	public static void main(String[] args) {
		int arr[] = { 6, 8, 6, 6 };
		bubbleSort(arr);

	}

	private static void bubbleSort(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			boolean swapped = false;
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
				//swap(arr[j], arr[j + 1]);
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}
			if (swapped == false)				
				break;
		}
		System.out.print(Arrays.toString(arr));
		System.out.println();
	}

	private static void swap(int i, int j) {
		int temp = i;
		i = j;
		j = temp;
	}
}
