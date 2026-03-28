package com.mapsDemo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo {

	public static void main(String[] args) {
		
		//maintain the insertion order due to red black tree implementation
//		Map<Integer,String>map= new TreeMap<>();
		//reverse order
//		Map<Integer,String>map= new TreeMap<>(Comparator.reverseOrder());
		
		//doese not maintain the order of insertion
//		Map<Integer,String>map= new HashMap<>();
		
		TreeMap<Integer,String>map= new TreeMap<>();
		
		System.out.println(map.size());
		
	
		
		map.put(1, "shubham");
		map.put(2, "vishal");
		map.put(3, "ashish");
		map.put(4, "deepak");
		map.put(5, "pratik");
		map.put(6, "rohan");
		map.put(7, "ram");
		map.put(8, "shyam");
		
		for(Map.Entry<Integer,String> entry: map.entrySet()) {
			
			System.out.println(entry.getKey()+" - "+entry.getValue());
		}
		
		System.out.println();
		if(!map.isEmpty()) {
			
			System.out.println("first key "+map.firstKey());
			System.out.println("last key "+map.lastKey());
			}
			
		
		

	}

}
