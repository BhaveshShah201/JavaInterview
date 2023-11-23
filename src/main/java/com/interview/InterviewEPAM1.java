package com.interview;

public class InterviewEPAM1 {

	public static void main(String[] args) {
		int[] arr = { 15, 4, -2, 2, -3, 1, 3, 3, 0 };
		int targerSum = 4;
		System.out.println(maxSumFromArray(arr, targerSum));
	}

	public static int maxSumFromArray(int[] arr, int sum) {
		int finalCnt = 0;
		if (arr.length < 1) {
			return finalCnt;
		} else if (arr.length == 1) {
			if (sum == arr[0]) {
				return arr[0];
			} else {
				return finalCnt;
			}
		} else {

			for (int i = 0; i < arr.length; i++) {
				int maxSum = arr[i];
				int maxCnt = 1;
				for (int j = i + 1; j < arr.length; j++) {
					maxSum = maxSum + arr[j];
					++maxCnt;
//					System.out.println(maxSum + "-" + maxCnt + "-" + finalCnt);
					if (maxSum == sum) {
						if (finalCnt < maxCnt) {
							finalCnt = maxCnt;
						}
					}
				}
			}
		}
		return finalCnt;

	}
//	public static int maxSumFromArray(int[] arr, int sum) {
//		int finalCnt = 0;
//		if (arr.length < 1) {
//			return finalCnt;
//		} else if (arr.length == 1) {
//			if (sum == arr[0]) {
//				return arr[0];
//			} else {
//				return finalCnt;
//			}
//		} else {
//			int midSum = 0;
//			int maxCnt = 0;
//			for (int i = 0; i < arr.length - 1; i++) {
//				midSum = midSum + arr[i] + arr[i + 1];
//				if (sum == midSum) {
//					if (finalCnt < maxCnt) {
//						finalCnt = maxCnt;
//					}
//				} else {
//					maxCnt++;
//				}
//			}
//		}
//
//		return finalCnt;
//	}
}
