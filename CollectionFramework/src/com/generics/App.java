package com.generics;


// example without generics
/*
public class App {

	// Without using generics

	public static void getVal(int a, int b) {

		int result = a + b;
		System.out.println("result=" + " " + result);

	}

	// method Overloading
	public static void getVal(double a, double b) {
		double result = a + b;
		System.out.println("result from overidden method=" + " " + result);
	}
	

	public static void main(String[] args) {

		getVal(10, 30);

	}

}
*/

//Generics Examlple  <> is called diamond operator

class Store<T> {
	
	private T item;
	
	public void setItem(T item) {
		this.item=item;
	}
	
	public T getItem() {
		return this.item;
	}
	
}


class Hashtable<K,V>{
	
	private K key;
	private V value;
	
	public Hashtable(K key, V value){
		this.key=key;
		this.value=value;	
	}

	@Override
	public String toString() {
		return "Hashtable [key=" + key + ", value=" + value + "]";
	}
	
	
}


public class App{
	
public static void main(String[] args) {
		
		Store<String> item= new Store<>();
		
		item.setItem("shubham");
		
//	System.out.println(item);
	
	System.out.println(item.getItem());
	
	Store<Integer> num= new Store<>();
	
	num.setItem(10);
	System.out.println(num.getItem());
	
	
	Hashtable<Integer,String> hashtable= new Hashtable<>(1,"shubham");
	
	System.out.println(hashtable);
		
	
		
	}
	
}
