package com.dsa.arrays;

public class Arrays12to13 {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 9, 8, 7, 6, 5 };
		System.out.println(maxDiff(arr));
//		leaderOp(arr);
//		System.out.println();
//		leaderOp(arr);
//		reverseArray(arr, 2);
//		for (int i : arr) {
//			System.out.print(i + " ");
//		}

	}

	public static void leaderOp(int arr[]) {
		int cur_leader = arr[arr.length - 1];
		System.out.println(cur_leader);
		for (int i = arr.length - 2; i >= 0; i--) {
			if (cur_leader < arr[i]) {
				cur_leader = arr[i];
				System.out.println(cur_leader);
			}
		}

	}

	public static int maxDiff(int arr[]) {
		int res = arr[1] - arr[0];
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				res = Math.max(res, arr[j] - arr[i]);
			}
		}
		return res;
	}

	public static void leader(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			boolean flag = false;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] >= arr[i]) {
					flag = true;
					break;
				}
			}
			if (flag == false) {
				System.out.println(arr[i]);
			}
		}

	}

	public static void reverseArray(int arr[], int d) {
		rotateArryOpt2(arr, 0, d - 1);
		rotateArryOpt2(arr, d, arr.length - 1);
		rotateArryOpt2(arr, 0, arr.length - 1);

	}

	public static void rotateArryOpt2(int arr[], int low, int high) {
		while (low < high) {
			int temp = arr[low];
			arr[low] = arr[high];
			arr[high] = temp;
			low++;
			high--;
		}
	}

	public static void rotateArrayOpt1(int arr[], int d) {
		int temp[] = new int[d];
		for (int i = 0; i < d; i++)
			temp[i] = arr[i];
		for (int i = d; i < arr.length; i++)
			arr[i - d] = arr[i];
		for (int i = 0; i < d; i++)
			arr[arr.length - d + i] = temp[i];
	}

	public static void rotateArray(int arr[], int d) {
		for (int i = 0; i < d; i++) {
			rotateArrayOne(arr);
		}
	}

	private static void rotateArrayOne(int[] arr) {
		int temp = arr[0];
		for (int i = 1; i < arr.length; i++) {
			arr[i - 1] = arr[i];
		}
		arr[arr.length - 1] = temp;
	}
}
