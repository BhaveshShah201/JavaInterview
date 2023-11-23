package com.interview;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = { 5, 3, 1, 2, 9, 4, 0 };
		int[] sortedArr = selectionSort(arr);
		System.out.println(Arrays.toString(sortedArr));
	}

	public static int[] selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
//				System.out.println(i + "-" + j);
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			swap(arr, i, minIndex);
		}
		return arr;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}
}
