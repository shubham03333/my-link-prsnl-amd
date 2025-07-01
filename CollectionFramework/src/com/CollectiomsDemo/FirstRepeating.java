package com.CollectiomsDemo;

import java.util.stream.Stream;

public class FirstRepeating {

	public static void main(String[] args) {
		
		
		String str= "abbcd";
		
		 Stream<Character> ch=str.chars().mapToObj(c -> (char) c).distinct();
//		 System.out.println(ch.findFirst());
		 System.out.println(ch.toArray().toString());
		
		

	}

}
