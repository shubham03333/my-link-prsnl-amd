package com.CollectiomsDemo;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.ArrayList;
import java.util.LinkedList;
import com.CollectiomsDemo.*;

public class ListDemo {

	public static void main(String[] args) {
//
//		List<String> names = new ArrayList<>();
//
//		names.add("shubham");
//		names.add("vishal");
//		names.add("onkar");
//		names.add("sunil");
//
//		names.add(0, "shubh");
//
//		names.remove("vishal");
//		names.remove(3);
//		
//		
//
//		System.out.println(names.size());
//
//		for (String name : names) {
//			System.out.println(name);
//		}
//
//		System.out.println();
//		System.out.println(names.contains("Shubham"));
		
		//stack Demo
//		Stack<String> stk = new Stack<>();
//
//		stk.push("shubham");
//		stk.push("vishal");
//		stk.push("pratik");
//		stk.push("deepak");
//		System.out.println(stk.peek());
//		System.out.println(stk.pop());
//
//		System.out.println(stk.size());
		
		
		//QUEUE Demo
		
Queue<String>queue= new LinkedList<>();
		
		System.out.println("queue size= "+queue.size());
		
		queue.add("shubham");
		queue.add("vishal");
		queue.add("ashish");
		queue.add("deepak");
		
//		for(String s: queue) {
//			System.out.println(s);
//		}
		
		
//		while(!queue.isEmpty()) { //infinite loop
//			
//			System.out.println(queue);  
//		}
		
//		System.out.println("element "+queue.element());
//		
////		while(!queue.isEmpty()) { 
////			
////			System.out.println(queue.remove());  
////		}
//		
//		queue.offer("sam");
////		System.out.println(queue.en);
//		
//		System.out.println("Peek "+queue.peek());
//		
//		
//		System.out.println("poll "+queue.poll());
//		
//		for(String s: queue) {
//		System.out.println(s);
//	}
//		
//		
//		System.out.println("queue size= "+queue.size());
		
		//Priority queue
		
		Queue<Person> person= new PriorityQueue<>();
		
//		person.add(new Person(27,"shubham"));
//		person.add(new Person(26,"vishal"));
//		person.add(new Person(28,"ashish"));
//		person.add(new Person(29,"deepak"));
//		
////		for(Person p: person) {
////			System.out.println(p);
////		}
//		
//		while(person.peek() !=null) {
//			System.out.println(person.poll());
//		}
//		
//		System.out.println("size of priority queue after poll "+person.size());
//	}

}
}
