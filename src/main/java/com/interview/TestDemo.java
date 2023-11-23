package com.interview;

public class TestDemo {

	public static void main(String[] args) {
		pringPattern(5);
	}

	public static void pringPattern(int len) {
//		int totalLen = len + len -1;
		int incr = 1;
		for (int i = 0; i < len; i++) {
			int inc = i + incr++;
			int pat = 1;
			for (int j = 1; j <= inc; j++) {
				if (j != 1 && j <= inc/2+1) {
					pat = pat + 2;
				} else if (j != 1 && j > inc/2) {
					pat = pat - 2;
				}
				System.out.print(pat + " ");
			}
			System.out.println("");
		}
	}
}
