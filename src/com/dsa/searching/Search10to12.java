package com.dsa.searching;

public class Search10to12 {
	public static void main(String[] args) {
		int arr[] = { 6, 7, 8, 20, 12 };
		System.out.println(" Peak element in array not smaller than the Neighbours");
		System.out.println(isPeak(arr));
		System.out.println("is peak optimized code");
		System.out.println(isPeakOp(arr));
		int arr1[] = { 2, 3, 8, 11 };
		System.out.println("is pair Naive Solution");
		int x = 14;
		System.out.println(isPariNaive(arr1, x));
		System.out.println("is pair efficient solution");
		System.out.println(isPairTwoPointA(arr1, x));
		System.out.println("Triplet pair checking");
		int arr2[] = { 2, 3, 5, 6, 15 };
		int x2 = 20;
		System.out.println(isTripletNaive(arr2, x2));
		System.out.println("Triplet pair checking using two pointer approach ");
		System.out.println(isTripletOpTwoPoin(arr2, x2));
	}

	private static boolean isTripletOpTwoPoin(int arr[], int x) {
		for (int i = 0; i < arr.length - 2; i++) {
			if (isPairCallToTrip(arr, x - arr[i], i + 1))
				return true;
		}
		return false;
	}

	private static boolean isPairCallToTrip(int arr[], int x, int si) {
		int i = si, j = arr.length - 1;
		while (i <= j) {
			if (arr[i] + arr[j] == x)
				return true;
			else if (arr[i] + arr[j] > x)
				j--;
			else
				i++;
		}
		return false;
	}

	private static boolean isTripletNaive(int arr[], int x) {
		for (int i = 0; i < arr.length - 2; i++) {
			for (int j = i + 1; j < arr.length - 1; j++) {
				for (int k = j + 1; k < arr.length; k++) {
					if (arr[i] + arr[j] + arr[k] == x)
						return true;
				}
			}
		}
		return false;
	}

	private static boolean isPairTwoPointA(int arr[], int x) {
		int i = 0, j = arr.length - 1;
		while (i <= j) {
			if (arr[i] + arr[j] == x)
				return true;
			if ((arr[i] + arr[j]) > x)
				j--;
			else
				i++;
		}
		return false;
	}

	private static boolean isPariNaive(int arr[], int x) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == x)
					return true;
			}
		}
		return false;
	}

	private static int isPeak(int arr[]) {
		if (arr.length == 1)
			return arr[0];
		if (arr[0] >= arr[1])
			return arr[0];
		if (arr[arr.length - 1] >= arr[arr.length - 2])
			return arr[arr.length - 1];
		for (int i = 1; i < arr.length - 1; i++) {
			if (arr[i] >= arr[i + 1] && arr[i] >= arr[i - 1])
				return arr[i];
		}
		return -1;
	}

	private static int isPeakOp(int arr[]) {
		int low = 0, high = arr.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if ((mid == 0 || arr[mid] >= arr[mid - 1]) && (mid == arr.length - 1 || arr[mid] >= arr[mid + 1]))
				return arr[mid];
			else if (mid > 0 && arr[mid] < arr[mid - 1])
				high = mid - 1;
			else
				low = mid + 1;
		}
		return -1;
	}
}
