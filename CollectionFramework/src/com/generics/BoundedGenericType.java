package com.generics;


class Employee implements Comparable<Employee> {
	
	private int age;
	private String name;
	
	public Employee(int age, String name) {
		this.age=age;
		this.name=name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String getName() {
		return this.name;
	}

	@Override
	public int compareTo(Employee otherEmployee) {
		
		return Integer.compare(age, otherEmployee.getAge());
	}

	@Override
	public String toString() {
		return "Employee [age=" + age + ", name=" + name + "]";
	}
	
	
}



//bounded generic
public class BoundedGenericType {

	public static <T extends Comparable<T>> T getMinValue(T t1, T t2) {

		if (t1.compareTo(t2) < 0)
			return t1;

		return t2;

	}
	
// adding 2 number of any primitive type using bounded generic
	
	public static <T extends Number> double addNum(T t1, T t2) {
		
		double num=t1.doubleValue()+t2.doubleValue();
		return num;
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		System.out.println("min value is "+BoundedGenericType.getMinValue("Shubham", "Amay"));
		
//		Employee emp= new Employee();
		
		
//		System.out.println("min value is "+ getMinValue(new Employee(28,"shubham"), new Employee(27,"vishal")));
		
		System.out.println(addNum(10, 60.5));

	}

}
