package com.java.interview;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = { 5, 3, 1, 2, 9, 4, 0 };
		int[] sortedArr = quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(sortedArr));
	}

	public static int[] quickSort(int[] arr, int low, int high) {
		if (low >= high)
			return arr;
		int pi = new Random().nextInt(high - low) + low;
		int pivot = arr[pi];
		swap(arr, pi, high);
		int pivotPosition = partition(arr, low, high, pivot);
		quickSort(arr, low, pivotPosition - 1);
		quickSort(arr, pivotPosition + 1, high);
		return arr;
	}

	static int partition(int[] arr, int low, int high, int pivot) {
		int i = (low - 1);
		for (int j = low; j <= high - 1; j++) {
			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return (i + 1);
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}
}
