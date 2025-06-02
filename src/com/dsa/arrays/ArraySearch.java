package com.dsa.arrays;

public class ArraySearch {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int arr[] = { 20,20, 5, 7, 25 };
		int x = 5;
		int pos = 3;
		// o/p 1
		System.out.println(largestIdx(arr));
		System.out.println(secondLargestIdx(arr));
		System.out.println(secondLargestIdxOptimized(arr));
		System.out.println(linearSearch(arr, x));
		System.out.println(insert(arr, pos, x));
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println(deletion(arr, x));
		for (int i : arr) {
			System.out.print(i + " ");
		}

	}

	public static int secondLargestIdxOptimized(int arr[]) {
		int larg = 0;
		int second = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > arr[larg]) {
				second = larg;
				larg = i;
			} else if (arr[i] != arr.length) {
				if (second == -1 || arr[i] > arr[second]) {
					second = i;
				}
			}
		}
		return second;

	}

	public static int secondLargestIdx(int arr[]) {
		int larg = largestIdx(arr);
		int res = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != arr[larg]) {
				if (res == -1)
					res = i;
				if (arr[i] > arr[res])
					res = i;
			}
		}
		return res;
	}

	public static int largestIdx(int arr[]) {
		int larg = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > arr[larg])
				larg = i;
		}
		return larg;
	}

	public static int deletion(int arr[], int x) {
		int i = 0;
		for (i = 0; i < arr.length; i++) {
			if (arr[i] == x) {
				break;
			}
		}

		if (i == arr.length)
			return arr.length;
		for (int j = i; j < arr.length - 1; j++) {
			arr[j] = arr[j + 1];
		}
		return arr.length - 1;
	}

	public static int insert(int arr[], int pos, int x) {
		if (arr.length == pos)
			return arr.length;
		int idx = pos - 1;
		for (int i = arr.length - 1; i < idx; i--)
			arr[i + 1] = arr[i];
		arr[idx] = x;

		return arr.length;
	}

	public static int linearSearch(int arr[], int x) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == x)
				return i;
		}
		return -1;
	}
}
