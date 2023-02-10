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
		
		/* To find Even Numbers from a List: */
		List<Integer> evenList = numsList.stream().filter( i -> i %2 == 0).collect(Collectors.toList());
		System.out.println("EvenList: --> " +evenList);
		
		/* To find Even Numbers from an Array - Boxing - convert primitive values to their wrapper:*/
		int[] numsArr = {1,2,3,4,5,6,7};
		List<Integer> evenArrList = Arrays.stream(numsArr).filter(i->i%2 == 0).boxed().collect(Collectors.toList());
		System.out.println("evenArrList --> " + evenArrList);
		
		/* convert from the wrapper class stream to the primitive stream */
		int sum = Arrays.asList(33,45).stream().mapToInt(i -> i).sum();
		System.out.println(sum);
	}
}
