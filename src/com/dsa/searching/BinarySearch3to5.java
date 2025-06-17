package com.dsa.searching;

public class BinarySearch3to5 {
	public static void main(String[] args) {
		System.out.println("find first Occurance Linear Approach");
		int arr[] = { 1, 10, 10, 10, 20, 20, 40 };
		int x = 10;
		System.out.println(firstOccLinear(arr, x));
		int low = 0, high = arr.length - 1;
		System.out.println("find first Occurance Binary Search with Recursive Approach");
		System.out.println(firstOccBinarSeachRecu(arr, x, low, high));
		System.out.println("find first Occurance Binary Search with Interative Approach");
		System.out.println(firstOccIteraBinarySearch(arr, x));
		System.out.println("find last Occurance Linear Approach");
		System.out.println(lastOccLinear(arr, x));
		System.out.println("find Last Occurance Binary Search with Recursive Approach");
		System.out.println(lastOccBinarySearchRecu(arr, x, low, high));
		System.out.println("find last Occurance Binary Search with Interative Approach");
		System.out.println(lastOccIterativeBinaryseach(arr, x));
	}

	private static int lastOccLinear(int arr[], int x) {
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] == x)
				return i;
		}
		return -1;
	}

	private static int firstOccLinear(int arr[], int x) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == x)
				return i;
		}
		return -1;
	}

	private static int lastOccBinarySearchRecu(int arr[], int x, int low, int high) {
		if (low > high)
			return -1;
		int mid = (low + high) / 2;
		if (arr[mid] > x)
			return lastOccBinarySearchRecu(arr, x, low, mid - 1);
		else if (arr[mid] < x)
			return lastOccBinarySearchRecu(arr, x, mid + 1, high);
		else {
			if (mid == arr.length - 1 || arr[mid] != arr[mid + 1])
				return mid;
			else
				return lastOccBinarySearchRecu(arr, x, mid + 1, high);
		}
	}

	private static int firstOccBinarSeachRecu(int arr[], int x, int low, int high) {
		if (low > high)
			return -1;
		int mid = (low + high) / 2;
		if (arr[mid] > x)
			return firstOccBinarSeachRecu(arr, x, low, mid - 1);
		else if (arr[mid] < x)
			return firstOccBinarSeachRecu(arr, x, mid + 1, high);
		else {
			if (mid == 0 || arr[mid] != arr[mid - 1])
				return mid;
			else
				return firstOccBinarSeachRecu(arr, x, low, mid - 1);
		}
	}

	private static int lastOccIterativeBinaryseach(int arr[], int x) {
		int low = 0, high = arr.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] > x)
				low = mid - 1;
			else if (arr[mid] < x)
				high = mid + 1;
			else {
				if (mid == arr.length - 1 || arr[mid] != arr[mid + 1])
					return mid;
				else
					high = mid + 1;
			}
		}
		return -1;
	}

	private static int firstOccIteraBinarySearch(int arr[], int x) {
		int low = 0, high = arr.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] > x)
				high = mid - 1;
			else if (arr[mid] < x)
				low = mid + 1;
			else {
				if (mid == 0 || arr[mid] != arr[mid - 1])
					return mid;
				else
					high = mid - 1;
			}

		}
		return -1;
	}
}
