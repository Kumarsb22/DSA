package com.dsa.sorting;

import java.util.Arrays;

public class Sort5Problem {
	public static void main(String[] args) {
		int arr[] = { 6, 8, 6, 6 };
		bubbleSort(arr);
		int arr1[] = { 10, 5, 8, 20, 2, 18 };
		selectionSort(arr1);
		int arr2[] = { 10, 5, 8, 20, 2, 18 };
		insertionSort(arr2);
		merge(arr, arr1);
		efficentMerge(arr1, arr2);
	}

	private static void bubbleSort(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			boolean swapped = false;
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					// swap(arr[j], arr[j + 1]);
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}
			if (swapped == false)
				break;
		}
		System.out.print(Arrays.toString(arr));
		System.out.println();
	}

	private static void swap(int i, int j) {
		int temp = i;
		i = j;
		j = temp;
	}

	private static void selectionSort(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			int min_ind = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[min_ind]) {
					min_ind = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[min_ind];
			arr[min_ind] = temp;
		}
		System.out.println("Selection Sorting");
		System.out.println(Arrays.toString(arr));
	}

	private static void insertionSort(int arr[]) {
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
		System.out.println("Insertion Sort ");
		System.out.println(Arrays.toString(arr));
	}

	private static void merge(int a[], int b[]) {
		int temp[] = new int[a.length + b.length];
		int ind = 0;
		for (int i = 0; i < a.length; i++)
			temp[ind++] = a[i];
		for (int i = 0; i < b.length; i++)
			temp[ind++] = b[i];
		Arrays.sort(temp);
		System.out.println("Merging the two arrays");
		System.out.println(Arrays.toString(temp));
	}

	private static void efficentMerge(int a[], int b[]) {
		int i = 0, j = 0;
		int n = a.length-1, m = b.length-1;
		while (i < n && j < m) {
			if (a[i] <= a[j]) {
				i++;
				System.out.print(a[i] + " ");
			} else {
				j++;
				System.out.print(b[j] + " ");
			}
		}

		while (i < n) {
			i++;
			System.out.print(a[i] + " ");
		}
		while (j < m) {
			j++;
			System.out.print(b[j] + " ");
		}
	}
	
	private void merge(int a[],int low, int mid, int high) {
		int n1=mid-low+1, n2=high-mid;
		int left[] = new int[n1];
		int right[]=new int[n2];
		for(int i=0;i<n1;i++) {
			left[i]=a[low+i];
		}
	}
}
