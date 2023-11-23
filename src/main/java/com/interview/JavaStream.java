package com.interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JavaStream {

	public static void main(String[] args) {
		List<Integer> lst = Arrays.asList(1, 5, 7, 2, 4, 1, 4);
		List<String> strLst = Arrays.asList("bhavesh", "hetal", "harsha", "nidhi", "amar");
		printAverage(lst);
		printCapital(strLst);
		sumOfAllOddEven(lst);
		removeDuplicate(lst);
		countStringStartWith(strLst, "h");
		sortAscDesc(strLst);
		minMax(lst);
		secondMinMax(lst);
		listToMap(strLst);
	}

	public static void printAverage(List<Integer> lst) {
		Double avg = lst.stream().collect(Collectors.averagingLong(i -> i));
		System.out.println("Average-->" + avg);
	}

	public static void printCapital(List<String> lst) {
		List<String> newLst = lst.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println("UpperCase-->" + newLst);
	}

	public static void sumOfAllOddEven(List<Integer> lst) {
		int evens = lst.stream().filter(i -> i % 2 == 0).collect(Collectors.summingInt(i -> i));
		int odds = lst.stream().filter(i -> i % 2 != 0).collect(Collectors.summingInt(i -> i));
		System.out.println("Odd sum-->" + odds);
		System.out.println("Even sum-->" + evens);
	}

	public static void removeDuplicate(List<Integer> lst) {
		List<Integer> newList = lst.stream().distinct().collect(Collectors.toList());
		System.out.println("remove duplicate-->" + newList);
	}

	public static void countStringStartWith(List<String> lst, String startWith) {
		Long start = lst.stream().filter(str -> str.toLowerCase().startsWith(startWith.toLowerCase())).count();
		System.out.println("Strings start with " + startWith + "-->" + start);
	}

	public static void sortAscDesc(List<String> lst) {
		List<String> ascList = lst.stream().sorted().collect(Collectors.toList());
		List<String> descList = lst.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println("sorted ASC-->" + ascList);
		System.out.println("sorted DESC-->" + descList);
	}

	public static void minMax(List<Integer> lst) {
		Integer max = lst.stream().max(Integer::compare).get();
		Integer min = lst.stream().min(Integer::compare).get();
		System.out.println("Max -->" + max + " --> Min --> " + min);
	}

	public static void secondMinMax(List<Integer> lst) {
		Integer smallest = lst.stream().distinct().sorted().skip(1).findFirst().get();
		Integer largest = lst.stream().distinct().sorted((a, b) -> Integer.compare(b, a)).skip(1).findFirst().get();
		System.out.println("Second Smallest -->" + smallest + " --> Second Largest --> " + largest);
	}

	public static void listToMap(List<String> lst) {
		Map<Integer, String> mp = lst.stream().collect(Collectors.toMap(str -> lst.indexOf(str), Function.identity()));
		System.out.println("list to map-->" + mp);
	}

}
