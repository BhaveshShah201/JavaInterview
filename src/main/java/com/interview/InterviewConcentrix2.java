package com.interview;

public class InterviewConcentrix2 {

	public static void main(String[] args) {
//				3[a] => aaa
//				10[ab]3[c] => ababccc
//				ab3[d] => abddd
//				2[a2[c]] => accacc

		String str = "ab3[d]";
		System.out.println(permutation(str));

	}

	public static String permutation(String str) {
		StringBuilder sb = new StringBuilder();
		String digit = "";
		String intStr = "";
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				digit = digit + str.charAt(i);
			} else {
				if (!digit.isEmpty() && str.charAt(i) != ']' && str.charAt(i) != '[') {
					intStr = intStr + str.charAt(i);
				} else if (digit.isEmpty()) {
					sb.append(str.charAt(i));	
				}
				else if (str.charAt(i) == ']') {
					sb.append(intStr.repeat(Integer.parseInt(digit)));
					digit = "";
					intStr = "";
				}
			}
//			System.out.println(intStr);
		}

		return sb.toString();
	}
}
