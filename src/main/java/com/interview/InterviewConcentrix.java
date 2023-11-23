package com.interview;

import java.util.Arrays;

public class InterviewConcentrix {

	public static void main(String[] args) {
//		int[] arr = { -5, -4, -2, -1, 1, 2, 3 }; // 25 16 4 1 1 4 9 // 1 1 4 4 9 16 25
		int[] arr = { -100, -0, -1, -5, -6 }; // 25 16 4 1 1 4 9 // 1 1 4 4 9 16 25
		int[] newArr = new int[arr.length];
		int newArrPointer = arr.length - 1;
		int frontIndex = 0;
		int lastIndex = arr.length - 1;
		if (arr.length == 0) {
			System.out.println("Empty array");
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			int frontSquare = arr[frontIndex] * arr[frontIndex];
			int lastSquare = arr[lastIndex] * arr[lastIndex];
			if (frontSquare >= lastSquare) {
				newArr[newArrPointer] = frontSquare;
				newArrPointer--;
				frontIndex++;
			} else {
				newArr[newArrPointer] = lastSquare;
				newArrPointer--;
				lastIndex--;
			}
		}
		System.out.println(Arrays.toString(newArr));
	}
}
