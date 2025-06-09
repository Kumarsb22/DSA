package com.dsa.arrays;

public class Array22To24 {

	public static void main(String[] args) {
		int arr[] = { 8, 7, 6, 8, 6, 6, 6, 6 };
		System.out.println(findMajarity(arr));
		System.out.println("===============");
		int arr1[] = { 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1 };
		printGroup(arr1);
		System.out.println("===============");
		int arr2[] = { 1, 8, 30, -5, 20, 7 };
		System.out.println(maxSumSlidingWindow(arr2, 4));
		System.out.println("===============");
	}

	private static int maxSumSlidingWindow(int arr[], int k) {
		int curr = 0;
		for (int i = 0; i < k; i++)
			curr += arr[i];
		int res = curr;
		for (int i = k; i < arr.length; i++) {
			curr = curr + arr[i] - arr[i - k];
			res = Math.max(res, curr);
		}
		return res;
	}

	private static void printGroup(int arr[]) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != arr[i - 1]) {
				if (arr[i] != arr[0])
					System.out.println("From " + i + " to");
				else
					System.out.println(i - 1);
			}

		}
		if (arr[arr.length - 1] != arr[0])
			System.out.println(arr.length - 1);
	}

	private static int findMajarity(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			int count = 1;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j])
					count++;
			}
			if (count > arr.length / 2)
				return i;
		}
		return -1;
	}

}
