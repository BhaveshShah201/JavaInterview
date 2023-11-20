package com.java.interview;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InterviewGlobant {

	public static void main(String[] args) {
		List<String>  lst = Arrays.asList("ABC","abc","XYZ");
		List<String>  newLst = lst.stream().filter(str -> str.replaceAll("[A-Z]","").length() == 0).collect(Collectors.toList());
		System.out.println(newLst);
	}
}
