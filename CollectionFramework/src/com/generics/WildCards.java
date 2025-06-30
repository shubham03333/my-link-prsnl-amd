package com.generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WildCards {

	public static double sumAll(List<? extends Number> list) {

		double sum = 0;

		for (Number n : list) {
			sum += n.doubleValue();
		}

		return sum;

	}

	// toread the lis can use upper bounded wild card but for writing it will not
	// used

	public static void showAll(List<? extends Number> list) {

		for (Number n : list) {
			System.out.println(n);
		}
	}

	
	// Lower bounded wild cards. used when we wanto inser the item in list we cannot read the from the list
	
		//addItem(List<? super Integer>)
		
	
	public static void showAllUpperboundedwild(List<? super Number>list) {
		
		for(Object n : list) {
			System.out.println(n);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<? extends Number> l1 = new ArrayList<Integer>();
		List<? extends Number> l2 = new ArrayList<Double>();
		List<? extends Number> l3 = new ArrayList<Float>();

//		showAll(Arrays.asList(1.2, 2, 3, 4));
//		l1.add(Arrays.asList(1,2,3,4));
		
//		System.out.println(sumAll(Arrays.asList(10 ,20,30.1)));
		
		
		//Lower bounded wild card
		
		List<? super Integer> l4 = new ArrayList<Number>();
		List<? super Integer> l5 = new ArrayList<Number>();
		List<? super Integer> l6 = new ArrayList<Number>();
		
		showAllUpperboundedwild(Arrays.asList(1,2,3,4));
		
		List<Serializable> list = new ArrayList<>();
		
		list.add("shubham");
		list.add("shivaji");
		list.add("jadhav");
		
		showAllUpperboundedwild(list);
		
		
//		   public static <T> void copy(List<? extends T>list1, List<? super T>list2){
//		        
//			      for(int i=0; i<list1.size();i++){
//			          
//			          list2.add(list1.get(i));
//			      }
//			      
//			      
//			    }
//		
		
		
		
		

	}
	
	
	
	

}
