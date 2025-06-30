package com.dsa.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Sorting1 {
	public static void main(String[] args) {
		System.out.println("Primitive type data sorting");
		int arr1[] = { 5, 20, 12, 30 };
		char arr2[] = { 'B', 'B', 'A', 'C', 'A' };
		Arrays.sort(arr1);
		System.out.println(Arrays.toString(arr1));
		Arrays.sort(arr2);
		System.out.println(Arrays.toString(arr2));
		int arr3[] = { 5, 30, 20, 10, 8 };
		Arrays.sort(arr3, 1, 4);
		System.out.println(Arrays.toString(arr3));

		System.out.println("Reverse Order by using arrays");
		Integer arr4[] = { 5, 30, 20, 10, 8 };
		Arrays.sort(arr4, Collections.reverseOrder());
		System.out.println(Arrays.toString(arr4));

		System.out.println("Custom object sorting by implimenting the comparable interface");
		Point point[] = { new Point(10, 20), new Point(3, 12), new Point(5, 7), new Point(4, 5), new Point(6, 7) };
		Arrays.sort(point);
		for (int i = 0; i < point.length; i++) {
			System.out.println(point[i].x + "  ->  " + point[i].y);
		}

		System.out.println("Custom object sorting by implementing the comparator interface");
		Points points[] = { new Points(10, 20), new Points(3, 12), new Points(5, 7), new Points(4, 5),
				new Points(6, 7) };
		Arrays.sort(points, new MyCmp());
		for (int i = 0; i < points.length; i++) {
			System.out.println(points[i].x + "  ->  " + points[i].y);
		}

		System.out.println("Sort array all even number comes first and all odd number coomes at lost");
		Integer arr5[] = { 5, 20, 10, 3, 12 };
		Arrays.sort(arr5, new Mycamp());
		System.out.println(Arrays.toString(arr5));

		System.out.println("Collection.sort() function");
		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(5);
		list.add(20);
		System.out.println(list);
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list);

		System.out.println(
				"Custom sorting list by using implementing the comparable interface with Collections.sort() function");
		ArrayList<Point> arrayList = new ArrayList<>();
		arrayList.add(new Point(5, 10));
		arrayList.add(new Point(2, 20));
		arrayList.add(new Point(10, 30));
		Collections.sort(list);
		for (Point point2 : arrayList) {
			System.out.println(point2.x + " -> " + point2.y);
		}
		System.out.println(
				"Custom sorting list by using implementing the comparator interface with Collections.sort() function");

		ArrayList<Points> arrayList1 = new ArrayList<>();
		arrayList1.add(new Points(5, 10));
		arrayList1.add(new Points(2, 20));
		arrayList1.add(new Points(10, 30));
		Collections.sort(list, new Mycamp());
		for (Points points2 : arrayList1) {
			System.out.println(points2.x + " -> " + points2.y);
		}
	}

}
