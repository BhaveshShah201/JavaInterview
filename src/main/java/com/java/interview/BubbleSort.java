package com.java.interview;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = { 5, 3, 1, 2, 9, 4, 0 };
		int[] sortedArr = bubbleSort(arr);
		System.out.println(Arrays.toString(sortedArr));
	}

	public static int[] bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			boolean isSwapped = false;
			for (int j = 0; j < arr.length - i - 1; j++) {
//				System.out.println(i + "-" + j);
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
					isSwapped = true;
				}
			}
			if (!isSwapped) {
				break;
			}
		}
		return arr;
	}

//	private static void swap(int[] arr, int i, int j) {
//		int temp = arr[j];
//		arr[j] = arr[i];
//		arr[i] = temp;
//	}
//
//	private static void swap1(int[] arr, int i, int j) {
//		arr[i] = arr[i] + arr[j];
//		arr[j] = arr[i] - arr[j];
//		arr[i] = arr[i] - arr[j];
//	}
//
//	private static void swap2(int[] arr, int i, int j) {
//		arr[j] = arr[i] + arr[j] - (arr[i] = arr[j]);
//	}

	private static void swap(int[] arr, int i, int j) {
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
	}
}
