package com.noteslookup.util;

public class NullOrEmpty {

	public static void main(String[] args){
		System.out.println(isNullOrEmpty("a","a","n"));  // false
		System.out.println(isNullOrEmpty("","",""));  // true
		System.out.println(isNullOrEmpty("","",null));  // true
		System.out.println(isNullOrEmpty(null,null,null));  // true
		System.out.println(isNullOrEmpty(null,null,"a"));  // false
	}
	
	public static boolean isNullOrEmpty(String... strArr) {
		for (String st : strArr) {
			if (st != null && !"".equals(st)){
				return false;
			}
		}
		return true;
    }
}
