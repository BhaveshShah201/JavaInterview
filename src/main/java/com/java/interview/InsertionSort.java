package com.java.interview;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = { 5, 3, 1, 2, 9, 4, 0 };
		int[] sortedArr = insertionSort(arr);
		System.out.println(Arrays.toString(sortedArr));
	}

	public static int[] insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int j = i;
			while (j > 0 && arr[j] < arr[j - 1]) {
				System.out.println(i + "-" + j);
				swap(arr, j, j - 1);
				j--;
			}
		}
		return arr;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}
}
