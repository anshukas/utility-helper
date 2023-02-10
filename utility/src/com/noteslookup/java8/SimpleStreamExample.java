package com.noteslookup.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Set;

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
		
		/* To find Odd Numbers from a set: */
		Set<Integer> numbers = Set.of(1, 4, 8, 40, 11, 22, 33, 99); 
        Set<Integer> oddNumbers = numbers.stream(). 
                                   filter(o -> o % 2 != 0). 
                                    collect(Collectors.toSet());
        System.out.println("oddNumbers from set: --> " +oddNumbers);
        
		/* To find the first number which is divisible by both 2 and 3: */
        Integer findFirst = numsList.stream().filter(i->i%2 == 0).filter(i->i%3==0).findFirst().get();
        System.out.println("findFirst: --> "+findFirst);
        
		/* Program for map() to UPPERCASE */
        List<String> list = Arrays.asList("anshu", "shiwali", "ram");
        List<String> listUpperCase = list.stream().map(s->s.toUpperCase()).collect(Collectors.toList());
        System.out.println("listUpperCase: -->" + listUpperCase);
        
		/* Processing by sorted()method: */
        List<Integer> listUnsorted = Arrays.asList(10, 2, 1, 100, 50);
        List<Integer> listSorted = listUnsorted.stream().sorted().collect(Collectors.toList());
        System.out.println("ListSorted: --> " + listSorted);
        
		/* Customized order - Desc Order . */
        List<Integer> listSortedDesc = listUnsorted.stream().sorted((i1,i2) -> i2.compareTo(i1)).collect(Collectors.toList());
        System.out.println("listSortedDesc: -->" +listSortedDesc);
	}
}
