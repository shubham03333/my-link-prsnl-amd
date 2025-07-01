package com.api.pracUdm;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamStart {

	public static void main(String[] args) {
		
		
		int[] nums= {1,2,4,-5,6,7,8};
		
		//to convert array to stream
//		Arrays.stream(nums).forEach(x -> System.out.print(x+" "));;//
		
		//lambda x -> sop(x)
		Arrays.stream(nums).filter(x -> x%2==0).forEach(x -> System.out.print(x+" "));
		
		int sum= Arrays.stream(nums).sum();
		System.out.println("sum is= "+sum);
		
		
//		Iterable
		System.out.println();
		
//		IntStream.range(5, 10).forEach(x -> System.out.println(x));
		
		String[] names= {"Adam","Daniel","Martha","Kevin","Ben","Joe","Brad"};
		
		Stream.of(names).forEach(System.out::println);
		System.out.println();
		System.out.println("sorted list: ");
		Stream.of(names).sorted().forEach(System.out::println);//sorted in alphabaticale order
		
		System.out.println();
		System.out.println("Sorted in desc order: ");
		
		Stream.of(names).sorted(Comparator.reverseOrder()).forEach(System.out::println);
		
		System.out.println("start with method");
		Stream.of(names).filter(x -> x.startsWith("B")).forEach(System.out::println);
		
		
		//Strams on Collection
		
		
		List<String> nameList= new ArrayList<>();
		
		nameList.add("Adam");
		nameList.add("Ana");
		nameList.add("kevin");
		
		System.out.println();
		System.out.println("collection to Stream conversion: ");
		Stream<String> nameStream= nameList.stream();//converting ArrayList to stream
		
		nameStream.forEach(System.out::println);
//		nameStream.forEach(System.out::println); we cannot operate on stream multiple times
		
		

	}

}
