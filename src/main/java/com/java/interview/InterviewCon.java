package com.java.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InterviewCon {

	public static void main(String[] args) {
		
		String[] arr = {"A55@", "41#G", "%S87","30$F","T93*"};
		sortedCharacter(arr	);
	}
	
	public static void sortedCharacter(String[] chars) {
		
		String charReg = "[A-Z]";
		String degitReg = "[0-9]";
		String speReg = "[@#%$*]";
		
		List<String> charList = new ArrayList<>();
		List<String> degitList = new ArrayList<>();
		List<String> specialList = new ArrayList<>();
		
		for (String alpha : chars) {		
			charList.add(alpha.replaceAll(degitReg, "").replaceAll(speReg, ""));
			degitList.add(alpha.replaceAll(charReg, "").replaceAll(speReg, ""));
			specialList.add(alpha.replaceAll(charReg, "").replaceAll(degitReg, ""));			
		}
		Collections.sort(charList);
		Collections.sort(degitList);
		
		System.out.println(charList);
		System.out.println(degitList);
		System.out.println(specialList);
	}
}
