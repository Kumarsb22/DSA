package com.dsa.arrays;

public class Array19to21 {
	public static void main(String[] args) {
		int arr[] = { 1, 0, 1, 1, 1, 1, 0, 1, 1 };
		System.out.println(maxConecutiveOne(arr));
		System.out.println("======================");
		int arr1[] = { -3, 8, -2, 4, -5, 6 };
		System.out.println(maxSubArraySum(arr1));
		System.out.println("======================");
		int arr2[] = { 5, 10, 20, 6, 3, 8 };
		System.out.println(maxEvenOddSubArray(arr2));
		System.out.println("======================");
		int arr3[] = { 8 - 4, 3, -5, 4 };
		System.out.println(maxCircularSubArraySum(arr3));
		System.out.println("======================");
	}

	private static int maxCircularSubArraySum(int arr[]) {
		int max_normal = maxSubArraySum(arr);
		System.out.println(max_normal);
		if (max_normal < 0)
			return max_normal;
		int arr_sum = 0;
		for (int i = 0; i < arr.length; i++) {
			arr_sum += arr[i];
			arr[i] -= arr[i];
		}
		System.out.println(arr_sum);
		int max_circulor = arr_sum + maxSubArraySum(arr);
		return Math.max(max_normal, max_circulor);
	}

	private static int maxEvenOddSubArray(int arr[]) {
		int res = 1;
		int curr = 0;
		for (int i = 1; i < arr.length; i++) {
			if ((arr[i] % 2 == 0 && arr[i - 1] != 0) || (arr[i] % 2 != 0 && arr[i - 1] == 0)) {
				curr++;
				res = Math.max(curr, res);
			} else {
				curr = 1;
			}
		}
		return res;
	}

	private static int maxConecutiveOne(int arr[]) {
		int res = 0;
		int count = 0;
		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == 0) {
				count = 0;
			} else {
				count++;
				res = Math.max(count, res);
			}
		}
		return res;
	}

	private static int maxSubArraySum(int arr[]) {
		int res = arr[0];
		int maxEnding = arr[0];
		for (int i = 1; i < arr.length; i++) {
			maxEnding = Math.max(maxEnding + arr[i], arr[i]);
			res = Math.max(maxEnding, res);
		}
		return res;

	}
}
