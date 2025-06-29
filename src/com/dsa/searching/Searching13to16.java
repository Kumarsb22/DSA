package com.dsa.searching;

import java.util.Arrays;

public class Searching13to16 {
	public static void main(String[] args) {
		int a1[] = { 10, 20, 30 };
		int a2[] = { 5, 15, 25, 35, 45 };
		System.out.println("Median of two sorted Arrays (dont modified existing array");
		System.out.println(getMid(a1, a2));
		System.out.println(getMidNaiveSolve(a1, a2));
		int arr[] = { 0, 4, 1, 3, 5, 4, 6, 4 };
		System.out.println("Repeated Element");
		System.out.println(repeatElementNaiv1(arr));
		int arr1[] = { 0, 4, 1, 3, 5, 4, 6, 4 };
		System.out.println(repeatElementNaiv2(arr1));
		int arr2[] = { 0, 4, 1, 3, 5, 4, 6, 4 };
		System.out.println(repeatElementOpt(arr2));
		int arr3[] = { 0, 4, 1, 3, 5, 4, 6, 4 };
		System.out.println(findRepeating(arr3));
		System.out.println("Allocate a minum number of Pages");
		int arr5[] = {10,20,10,30};
		int k = 2, n = arr.length;
		//System.out.println(minPagesOp(arr5, n, k));
		System.out.println(minPages(arr5, n, k));
		

	}

	private static int minPagesOp(int arr[], int n, int k) {
		int sum = 0, mx = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			mx = Math.max(mx, arr[i]);
		}
		int low = mx, high = sum, res = 0;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (isFeassible(arr, n, k, mid)) {
				res = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return res;
	}

	private static boolean isFeassible(int arr[], int n, int k, int ans) {
		int req = 1, sum = 0;
		for (int i = 0; i < n; i++) {
			if (sum + arr[i] > ans) {
				req++;
				sum = arr[i];
			} else {
				sum += arr[i];
			}
		}
		return (req <= k);
	}

	private static int minPages(int arr[], int n, int k) {
		if (k == 1)
			return sum(arr, 0, n - 1);
		if (n == 1)
			return arr[0];
		int res = Integer.MAX_VALUE;
		for (int i = 1; i < n; i++)
			res = Math.min(res, Math.max(minPages(arr, i, k - 1), sum(arr, i, n - 1)));
		return res;
	}

	private static int sum(int arr[], int b, int e) {
		int s = 0;
		for (int i = b; i <= e; i++)
			s += arr[i];
		return s;

	}

	private static int findRepeating(int arr[]) {
		int slow = arr[0] + 1, fast = arr[0] + 1;
		do {
			slow = arr[slow] + 1;
			fast = arr[arr[fast] + 1] + 1;
		} while (slow != fast);
		slow = arr[0] + 1;
		while (slow != fast) {
			fast = arr[fast] + 1;
			slow = arr[slow] + 1;
		}
		return slow - 1;
	}

	private static int repeatElementOpt(int arr[]) {
		// o(n) time , o(n) space
		boolean visited[] = new boolean[arr.length - 1];
		for (int i = 0; i < arr.length; i++) {
			if (visited[arr[i]])
				return arr[i];
			else
				visited[arr[i]] = true;
		}
		return -1;
	}

	private static int repeatElementNaiv2(int arr[]) {
		// time o(n) space o(1)
		Arrays.sort(arr);// 0(log n)
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1])
				return arr[i];
		}
		return -1;
	}

	private static int repeatElementNaiv1(int arr[]) {
		// o(n2)
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j])
					return arr[i];
			}
		}
		return -1;
	}

	private static double getMidNaiveSolve(int a1[], int a2[]) {
		// 1)based on the a1 and a2 length create a new temp array
		int temp[] = new int[a1.length + a2.length];
		for (int i = 0; i < a1.length; i++) {
			temp[i] = a1[i];
		}
		for (int i = 0; i < a2.length; i++) {
			temp[i + a1.length] = a2[i];
		}
		for (int i : temp) {
			System.out.print(i + " ");
		}
		System.out.println();
		// 2)sort array
		Arrays.sort(temp);
		for (int i : temp) {
			System.out.print(i + " ");
		}
		System.out.println();
		int mid;
		// 3)if sorted array size is odd print mid if sorted array is even print mid two
		// element some value
		if ((temp.length % 2) != 0) {
			mid = (0 + temp.length - 1) / 2;
			return temp[mid];
		} else {
			mid = (0 + temp.length - 1) / 2;
			return ((temp[mid] + temp[mid + 1]) / 2);
		}

	}

	private static double getMid(int a1[], int a2[]) {
		int n1 = a1.length, n2 = a2.length;
		int bign = 0, end = n1;
		while (bign < end) {
			int i1 = (bign + end) / 2;
			int i2 = (n1 + n2 + 1) / 2 - i1;
			int min1 = (i1 == n1) ? Integer.MAX_VALUE : a1[i1];
			int max1 = (i1 == 0) ? Integer.MIN_VALUE : a1[i1 - 1];
			int min2 = (i2 == n2) ? Integer.MAX_VALUE : a2[i2];
			int max2 = (i2 == 0) ? Integer.MIN_VALUE : a2[i2 - 1];
			if (max1 <= min2 && max2 <= min1) {
				if ((n1 + n2) % 2 == 0)
					return (Math.max(max1, max2) + Math.min(min1, min2)) / 2;
				else
					return Math.max(max1, max2);
			} else if (max1 > min2)
				end = i1 - 1;
			else
				bign = i1 + 1;
		}
		return -1;
	}

}
