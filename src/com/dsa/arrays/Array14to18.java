package com.dsa.arrays;

public class Array14to18 {
	public static void main(String[] args) {
		// int arr[] = { 10, 10, 10, 25, 30, 30 };
		int arr[] = { 3, 0, 1, 2, 5 };
		printFreq(arr);
		System.out.println(getWater(arr));
		System.out.println("Maximum Profit is " + maxProfit(arr));
	}

	// Trapping Rain Water
	public static int getWater(int arr[]) {
		int res = 0;
		for (int i = 1; i < arr.length - 1; i++) {
			int lmax = arr[i];
			for (int j = 0; j < i; j++)
				lmax = Math.max(lmax, arr[j]);
			int rmax = arr[i];
			for (int j = i + 1; j < arr.length; j++)
				rmax = Math.max(rmax, arr[j]);
			res += Math.min(lmax, rmax) - arr[i];
		}
		return res;
	}

	// Stock Buy and Sell
	public static int maxProfit(int arr[]) {
		int res = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[i - 1])
				res += (arr[i] - arr[i - 1]);
		}
		return res;
	}

	// Frequency in sorted array
	public static void printFreq(int arr[]) {
		int freq = 1;
		int i = 1;
		while (i < arr.length) {
			while (i < arr.length && arr[i] == arr[i - 1]) {
				freq++;
				i++;
			}
			System.out.println(arr[i - 1] + " -> " + freq);
			freq = 1;
			i++;
			if (arr.length == 1 || arr[arr.length - 1] != arr[arr.length - 2]) {
				System.out.println(arr[arr.length - 1] + " -> " + 1);
			}
		}
	}
}
