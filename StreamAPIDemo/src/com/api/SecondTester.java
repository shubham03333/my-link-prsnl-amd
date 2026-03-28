package com.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SecondTester {

	public static void main(String[] args) {
		
		
		List<Employee>employeeList=new ArrayList<>();
		
		// Adding sample employees
        employeeList.add(new Employee(111, "Jiya Berin", 32, "Female", "HR", 2011, 25500.00));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales", 2015, 13500.00));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.00));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.00));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.00));
        employeeList.add(new Employee(166, "Iqbal Hussain", 24, "Male", "Sales", 2016, 10500.00));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Product Development", 2010, 27000.00));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.00));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales", 2016, 11500.00));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security", 2009, 11000.00));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.00));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.00));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Accounts", 2013, 21300.00));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales", 2017, 10700.00));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.00));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.00));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.00));
  
        
//        calculateAvgAndTotalSalary(employeeList);
//        listDownDepartWiseEmployees(employeeList);
//        avgSalOfMaleAndFemaleEmployees(employeeList);
//        getEmployeesFromSalesAndMarketing(employeeList);
//        mostWorkingExperience(employeeList);
//        getYoungestEmployee(employeeList);
        
//        deptWiseAvgSalary(employeeList);
        
//        countNumberEmpsInDepartment(employeeList);
        

//		sortEmployeesBasedOnNameAndSalary(employeeList)
//		employeesJoinedAfter2015(employeeList);
        
//        getHighestPaidEmployees(employeeList);
        
//        getAverageAgeOfEmployee(employeeList);
        
//        printAllDepartments(employeeList);
        
//        findNoOfMaleAndFemales(employeeList);
//        extractEmployeeGreaterThanXAmount(employeeList);
        
        thirdHighestSalaryEmp(employeeList);
	}
	
	
	private static void thirdHighestSalaryEmp(List<Employee>empList) {
		
		Employee empWithThirdHighestSal = empList.stream()
				.map(Employee::getSalary)
				.distinct()
				.sorted((a,b)->Double.compare(b, a))
				.skip(2)
				.findFirst()
				.flatMap(
						sal-> empList.stream()
									.filter(e->e.getSalary()==sal)
									.findFirst()
						)
				.orElse(null);
//		System.out.println(empWithThirdHighestSal);
		
		//using reverseorder
		
		System.out.println(
				empList.stream()
						.map(Employee::getSalary)
						.distinct()
						.sorted(Comparator.reverseOrder())
						.skip(2)
						.findFirst()
						.flatMap(
								sal-> empList.stream()
										.filter(e-> e.getSalary()==sal)
										.findFirst()	
								).get()
				);
		
	}
	private static void calculateAvgAndTotalSalary(List<Employee> employeelist) {
		// calculateAvgAndTotalSalary(employeelist);
		
		Double collect = employeelist.stream().collect(Collectors.averagingDouble(Employee::getSalary));
		System.out.println("Average salary: "+collect.doubleValue());
//		Average salary: 21170.58823529412
		
	}
	
	public static void listDownDepartWiseEmployees(List<Employee>employeeList) {
		
//		System.out.println(employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment)));
		
		employeeList.stream()
		.collect(Collectors.groupingBy(Employee::getDepartment))
		.entrySet().stream()
		.forEach(e->System.out.println(e.getKey()+" "+e.getValue()));
		
	}
	
	
	public static void avgSalOfMaleAndFemaleEmployees(List<Employee> employeeList) {
		
		employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getSalary)))
				.entrySet().stream()
				.forEach(e->System.out.println(e.getKey()+" "+e.getValue()));
				
	}
	
	public static void getEmployeesFromSalesAndMarketing(List<Employee>employeeList){
		
		employeeList.stream()
				.filter(e->e.getDepartment().equals("Sales"))
				.forEach(e->System.out.println(e.getDepartment()+" "+e.getName()));
	}
	
	public static void mostWorkingExperience(List<Employee> employeelist) {
		//most expericen means min joining year
		Employee employee = employeelist.stream()
				.min(Comparator.comparing(Employee::getYearOfJoining))
				.get();
		
		System.out.println(employee);
//		Employee [id=200, name=Jaden Dough, age=38, gender=Male, department=Security, yearOfJoining=2009, salary=11000.0]

		
	}
	
	private static void getYoungestEmployee(List<Employee> employeelist) {
		
		System.out.println(employeelist.stream().min(Comparator.comparing(Employee::getAge)).get());
	}
	
	private static void deptWiseAvgSalary(List<Employee> employeelist) {
		
		employeelist.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment,
						Collectors.averagingDouble(Employee::getSalary)))
				.entrySet().stream()
				.forEach(System.out::println);
//		
//		Product Development=31133.333333333332
//				Sales=11550.0
//				Infrastructure=15466.666666666666
//				HR=24100.0
//				Security=11000.0
//				Accounts=21300.0
		
		
	}
	
	private static void countNumberEmpsInDepartment(List<Employee> employeelist) {
		
		employeelist.stream()
					.collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()))
					.entrySet().stream()
					.forEach(System.out::println);
		
//		Product Development=6
//				Sales=4
//				Infrastructure=3
//				HR=2
//				Security=1
//				Accounts=1

		
	}
	

	private static void sortEmployeesBasedOnNameAndSalary(List<Employee> employeelist) {
		
		List<Employee> collect = employeelist.stream()
			.sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary))
			.collect(Collectors.toList());
		
//		System.out.println(collect);

//		[Employee [id=255, name=Ali Baig, age=23, gender=Male, department=Infrastructure, yearOfJoining=2018, salary=12700.0], Employee [id=199, name=Amelia Zoe, age=24, gender=Female, department=Sales, yearOfJoining=2016, salary=11500.0], Employee [id=277, name=Anuj Chettiar, age=31, gender=Male, department=Product Development, yearOfJoining=2012, salary=35700.0], Employee [id=166, name=Iqbal Hussain, age=24, gender=Male, department=Sales, yearOfJoining=2016, salary=10500.0], Employee [id=200, name=Jaden Dough, age=38, gender=Male, department=Security, yearOfJoining=2009, salary=11000.0], Employee [id=211, name=Jasna Kaur, age=27, gender=Female, department=Infrastructure, yearOfJoining=2014, salary=15700.0], Employee [id=111, name=Jiya Berin, age=32, gender=Female, department=HR, yearOfJoining=2011, salary=25500.0], Employee [id=233, name=Jyothi Reddy, age=27, gender=Female, department=Accounts, yearOfJoining=2013, salary=21300.0], Employee [id=177, name=Manu Sharma, age=35, gender=Male, department=Product Development, yearOfJoining=2010, salary=27000.0], Employee [id=133, name=Martin Theron, age=29, gender=Male, department=Infrastructure, yearOfJoining=2012, salary=18000.0], Employee [id=144, name=Murali Gowda, age=28, gender=Male, department=Product Development, yearOfJoining=2014, salary=32500.0], Employee [id=244, name=Nicolus Den, age=24, gender=Male, department=Sales, yearOfJoining=2017, salary=10700.0], Employee [id=155, name=Nima Roy, age=27, gender=Female, department=HR, yearOfJoining=2013, salary=22700.0], Employee [id=222, name=Nitin Joshi, age=25, gender=Male, department=Product Development, yearOfJoining=2016, salary=28200.0], Employee [id=122, name=Paul Niksui, age=25, gender=Male, department=Sales, yearOfJoining=2015, salary=13500.0], Employee [id=266, name=Sanvi Pandey, age=26, gender=Female, department=Product Development, yearOfJoining=2015, salary=28900.0], Employee [id=188, name=Wang Liu, age=31, gender=Male, department=Product Development, yearOfJoining=2015, salary=34500.0]]

		
		employeelist.sort(Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary));
		employeelist.forEach(System.out::println);
	}
	
	private static void employeesJoinedAfter2015(List<Employee> employeelist) {
		
		employeelist.stream()
				.filter(e-> e.getYearOfJoining()>2015)
				.forEach(System.out::println);
	}
	
	private static void getHighestPaidEmployees(List<Employee> employeelist) {
			
		System.out.print(employeelist.stream()
			.max(Comparator.comparing(Employee::getSalary))
			.get());
	}
	
	
	private static void getAverageAgeOfEmployee(List<Employee> employeelist) {
		
		double doubleValue = employeelist.stream()
				.collect(Collectors.averagingDouble(Employee::getAge))
				.doubleValue();
				
		System.out.println("AVG Age is = "+doubleValue);
//		AVG Age is = 28.0
	}
	
	private static void printAllDepartments(List<Employee> employeelist) {
			
		List<String>empDepts=employeelist.stream()
				.map(e-> e.getDepartment())
				.distinct()
				.collect(Collectors.toList());
		
		System.out.println(empDepts);
	}
	
	private static void findNoOfMaleAndFemales(List<Employee> employeelist) {
		
		employeelist.stream()
			.collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()))
			.entrySet().stream()
			.forEach(System.out::println);
		
//		Male=11
//				Female=6

	}
	
	private static void extractEmployeeGreaterThanXAmount(List<Employee> employeelist) {
		
		employeelist.stream()
				.filter(e->e.getSalary()>25000)
				.forEach(System.out::println);
	}
	
}