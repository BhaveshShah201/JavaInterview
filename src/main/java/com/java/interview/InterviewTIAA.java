package com.java.interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InterviewTIAA {

	static Set<String> set = new HashSet<>();

	public static void main(String[] args) {
		String s1 = "aacvgflddbc";
		List<String> list = new ArrayList<>();
		for (int i = 0; i < s1.length(); i++) {
			list.add(s1.charAt(i) + "");
		}
		List<String> newlist = list.stream().filter(s -> !addInSet(s)).collect(Collectors.toList());
		System.out.println(newlist);
		System.out.println(returnMinCoins(21));
	}

	public static boolean addInSet(String s) {
		return set.add(s);
	}

	public static int returnMinCoins(int coin) {
		int[] coins = { 10, 5, 2, 1 };
		int cnt = 0;
		int minCoin = 0;
		while (coin > 0) {
			int rem = coin / coins[cnt] >= 1 ? (coin / coins[cnt]) : 0;
			int mod = coin % coins[cnt];
			if (mod >= 0) {
				coin = mod;
				minCoin = minCoin + rem;
			}
			System.out.println("adding " + rem + " coins of " + coins[cnt]);
			cnt++;
		}
		return minCoin;
	}
}
