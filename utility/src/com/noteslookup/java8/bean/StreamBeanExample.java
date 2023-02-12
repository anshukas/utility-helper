package com.noteslookup.java8.bean;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamBeanExample {

	public static void main(String[] args) {
		
		List<User> userList = Arrays.asList(
					new User("anshu",33),
					new User("shiwali", 30),
					new User("Ram", 20)
				);
		/* 1.1 Sorted by age, natural order */
		List<User> userAgeSorted = userList.stream().sorted((o1,o2) -> o1.getAge() - o2.getAge()).collect(Collectors.toList());
		System.out.println(userAgeSorted);
	}
}
