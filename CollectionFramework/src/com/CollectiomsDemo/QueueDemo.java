package com.CollectiomsDemo;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {

	public static void main(String[] args) {
		
		
		Queue<String>queue= new LinkedList<>();
		
		System.out.println(queue.size());
		
		queue.add("shubham");
		queue.add("vishal");
		queue.add("ashish");
		queue.add("deepak");
		
		for(String s: queue) {
			System.out.println(s);
		}
	}

}
