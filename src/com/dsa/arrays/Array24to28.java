package com.dsa.arrays;

public class Array24to28 {
	public static void main(String[] args) {
		int arr[] = { 3, 2, 0, 4, 7 };
		System.out.println(isSubSum(arr, 6));
		System.out.println(isSubSumOpti(arr, 6));
		int arr1[] = { 2, 8, 3, 9, 6, 5, 4 };
		System.out.println(prefixSum(arr1, 1, 3));
		int arr2[] = { 3, 4, 8, -9, 20, 6 };
		System.out.println(equalibriumPoint(arr2));
		int left[]= {1,2};
		int rigth[]= {5,4};
		System.out.println(maxAppear(left, rigth));
	}

	private static int maxAppear(int left[], int right[]) {
		int freq[] = new int[100];
		for (int i = 0; i < left.length; i++) {
			for (int j = left[i]; j < right[i]; j++)
				freq[j] += 1;
		}
		int res = 0;
		for (int i = 1; i < 100; i++) {
			if (freq[i] > freq[res])
				res = i;
			return res;
		}
		return 0;

	}

	private static boolean equalibriumPoint(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			int ls = 0, rs = 0;
			for (int j = 0; j < i; j++)
				ls += arr[j];
			for (int k = i + 1; k < arr.length; k++)
				rs += arr[k];
			if (ls == rs)
				return true;
		}
		return false;
	}

	private static int prefixSum(int arr[], int l, int s) {
		int res = 0;
		for (int i = l; i <= s; i++)
			res += arr[i];
		return res;
	}

	private static boolean isSubSumOpti(int arr[], int sum) {
		int s = 0, res = 0;
		for (int e = 0; e < arr.length; e++) {
			res += arr[e];
			while (sum < res) {
				res -= arr[s];
				s++;
			}
			if (res == sum)
				return true;
		}
		return false;
	}

	private static boolean isSubSum(int arr[], int sum) {
		for (int i = 0; i < arr.length; i++) {
			int res = 0;
			for (int j = i; j < arr.length; j++) {
				res += arr[j];
				if (res == sum)
					return true;
			}
		}
		return false;
	}
}
