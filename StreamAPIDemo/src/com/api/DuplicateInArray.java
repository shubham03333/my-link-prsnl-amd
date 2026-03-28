package com.api;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateInArray {

	public static void main(String[] args) {
		
		int arr[]= {1,2,3,4,3,4,2};
		
		
//		Set<Integer> set= new HashSet<>();
//		
//		for(int i : arr) {
//			if(!set.add(i)) {
//				System.out.println(i);
//			}
//		}
		
		
		Arrays.stream(arr)
				.boxed()
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
				.entrySet().stream()
				.filter(entry-> entry.getValue()>1)
				.forEach(num-> System.out.print(num.getKey()+" "));

	}

}
