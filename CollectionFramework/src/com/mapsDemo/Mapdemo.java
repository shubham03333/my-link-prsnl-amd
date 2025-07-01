package com.mapsDemo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Mapdemo {

	public static void main(String[] args) {
	
		
		Map<Integer, String> map=new HashMap<>();
		
		map.put(1, "shubham");
		map.put(2, "vishal");
		map.put(3, "ashish");
		map.put(4, "deepak");
		
		
		for(Map.Entry<Integer, String> entry: map.entrySet()) {
		System.out.println(entry.getKey()+" - "+entry.getValue());	
		}
		
		//hashMap doese not maintain order of inseration
//		Map<String,Integer> map1= new HashMap<>();
		
		//LinkedHasgMap maitains the order of insertion
		//but need to more memory cause it uses doubly linkedlist
		Map<String,Integer> map1= new LinkedHashMap<>();
		
		map1.put("aaa", 1);
		map1.put("bbb", 2);
		map1.put("ccc", 3);
		map1.put("ddd", 4);
		map1.put("eee", 5);
		map1.put("fff", 6);
		map1.put("ggg", 7);
		map1.put("hhh", 8);
		map1.put("iii", 9);
		
		for(String str: map1.keySet()) {
			
			System.out.println(str+" "+map1.get(str));
		}
		
		

	}

}
