package com.dsa.arrays;

public class Arrays2 {

	public static void main(String[] args) {

		int arr[] = { 0, 0, 0, 10, 10, 10, 8, 12, 7, 7 };
		lRotateAr(arr);
		System.out.println("============");
		moveZeroToEnd(arr);
		System.out.println("============");
		System.out.println(isArSorted(arr));
		System.out.println("============");
		int[] rmDub = rmDubOp(arr);
		for (int i : rmDub) {
			System.out.print(i + " ");
		}
		System.out.println("============");
	}

	public static void lRotateAr(int arr[]) {
		int temp = arr[0];
		for (int i = 1; i < arr.length; i++) {
			arr[i - 1] = arr[i];
		}
		arr[arr.length - 1] = temp;

		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	public static void moveZeroToEnd(int arr[]) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				arr[count] = arr[i];
				arr[i] = 0;
				count++;
			}
		}
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	public static boolean isArSorted(int arr[]) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] > arr[i])
				return false;
		}
		return true;
	}

	public static int[] rmDubOp(int arr[]) {
		int res = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != arr[res - 1]) {
				arr[res] = arr[i];
				res++;
			}
		}
		return arr;
	}

	public static int[] rmDub(int arr[]) {
		int temp[] = new int[arr.length];
		temp[0] = arr[0];
		int res = 1;
		for (int i = 1; i < arr.length; i++) {
			if (temp[res - 1] != arr[i]) {
				temp[res] = arr[i];
				res++;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = temp[i];
		}
		return arr;
	}
}
