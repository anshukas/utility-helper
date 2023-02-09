package com.noteslookup.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/** 
 * 
 * @author anshukas
 *
 */
public class SimpleStreamExample {

	public static void main(String[] args) {
		/* To find Odd Numbers from a List: */
		List<Integer> numsList = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		List<Integer> oddList =  numsList.stream().filter(i -> i %2 != 0).collect(Collectors.toList());
		System.out.println("OddList: --> " + oddList);
	}
}
