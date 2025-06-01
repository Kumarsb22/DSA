package com.dsa.recursion;

public class RecursionPractice {

	public static void main(String[] args) {
		fun(2);
	}

	public static void fun(int n) {
		if (n == 0)
			return;
		System.out.println("Hello");
		fun(n - 1);
	}
}
