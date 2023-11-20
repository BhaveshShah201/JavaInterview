package com.java.interview;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class interviewIris {
	public static void main(String[] args) {
		List<Integer> lst = new ArrayList<Integer>();
		lst.add(5);
		lst.add(5);
		lst.add(2);
		lst.add(3);
		lst.add(5);
		System.out.println(findMaxnumber(lst));
	}

	public static int findMaxnumber(List<Integer> lst) {
		if (lst.isEmpty()) {
			return 0;
		}
		int ret = 0;
		Map<Integer, Integer> map = new HashMap<>();
		Collection<List<Integer>> mp = lst.stream().collect(Collectors.groupingBy(i -> i)).values();
		System.out.println(mp);
		for (Integer i : lst) {
			if (Objects.isNull(map.get(i))) {
				map.put(i, 1);
			} else {
				map.put(i, map.get(i) + 1);
			}
			if (ret < map.get(i)) {
				ret = i;
			}
		}
		return ret;
	}
}
