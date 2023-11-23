package com.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InterviewRapid {

	public static void main(String[] args) {
		Map<String, String> dilerMap = new HashMap<>();
		dilerMap.put("2", "abc");
		dilerMap.put("3", "def");
		dilerMap.put("4", "ghi");
		dilerMap.put("5", "jkl");
		dilerMap.put("6", "mno");
		dilerMap.put("7", "pqr");
		dilerMap.put("8", "stu");
		dilerMap.put("9", "wxyz");
		System.out.println(allPermutation("234", dilerMap));
	}

	public static List<String> allPermutation(String digits, Map<String, String> dilerMap) {
		List<String> retList = new ArrayList<>();
		List<String> combinations = new ArrayList<>();
		if(digits.isBlank()) {
			return retList;
		}
		for (int i = 0; i < digits.length(); i++) {
			String com = dilerMap.get(digits.charAt(i) + "");
			for (int j = 0; j < com.length(); j++) {
				combinations.add(com.charAt(j) + "");
			}
		}
		
		System.out.println(combinations);
		
		int len = dilerMap.get(digits.charAt(digits.length()-1) + "").length();
		System.out.println(len);
		for (int i = 0; i < combinations.size() - len; i++) {
			int defaultLen = 3;
			for (int j = defaultLen; j < combinations.size(); j++) {
				retList.add(combinations.get(i) + combinations.get(j));
			}
		}
		
		return retList;
	}
}
