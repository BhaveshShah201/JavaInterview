package com.java.interview;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InterviewEPAM {

	public static void main(String[] args) {
		String strSentence = " HI EPAM bYe EPAM goodbye EPAM welcome ePAM Hi There epAM BYE bye EPaM";

		List<String> arr = Arrays.asList(strSentence.split(" "));

		Map<String,Long> map =  arr.stream().collect(Collectors.groupingBy(str -> str.toLowerCase(), Collectors.counting()));
		map.entrySet().stream().filter(mp -> mp.getValue() > 1).forEach(System.out::println);
	}
}
