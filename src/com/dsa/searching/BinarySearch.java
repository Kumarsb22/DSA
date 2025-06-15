package com.dsa.searching;

public class BinarySearch {

	public static void main(String[] args) {
		int arr[] = { 10, 20, 30, 40, 50, 60, 70 };
		int x = 80;
		System.out.println(leanrsSearch(arr, x));
		System.out.println("======================");
		System.out.println(binarySearch(arr, x));
		System.out.println("======================");
		int low = 0;
		int high = arr.length - 1;
		System.out.println(binarySearchUsingRecursion(arr, x, low, high));
		System.out.println("======================");
	}

	public static int leanrsSearch(int arr[], int x) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == x)
				return i;
		}
		return -1;
	}

	public static int binarySearch(int arr[], int x) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == x)
				return mid;
			else if (arr[mid] > x)
				low = mid - 1;
			else
				low = mid + 1;
		}
		return -1;
	}

	public static int binarySearchUsingRecursion(int arr[], int x, int low, int high) {
		if (low > high)
			return -1;
		int mid = (low + high) / 2;
		if (arr[mid] == x)
			return mid;
		else if (arr[mid] > x)
			return binarySearchUsingRecursion(arr, x, low, mid - 1);
		else
			return binarySearchUsingRecursion(arr, x, mid + 1, high);
	}
}
