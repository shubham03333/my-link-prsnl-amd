package com.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SecondLevelOperations {
	
	public static void main(String[] args) {
	
		List<Employee> employeeList = new ArrayList<>();

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
        
        
	}
	
	private static void calculateAvgAndTotalSalary(List<Employee> employeelist) {
		// calculateAvgAndTotalSalary(employeelist);
				System.out.println("Average salary :: "
						+ employeelist.stream().collect(Collectors.averagingDouble(Employee::getSalary)).doubleValue());
				System.out.println("Sum of salary :: "
						+ employeelist.stream().collect(Collectors.summingDouble(Employee::getSalary)).doubleValue());
			}

			private static void listDownDepartWiseEmployees(List<Employee> employeelist) {
		// ListDownDepartWiseEmployees(employeelist);
				employeelist.stream().collect(Collectors.groupingBy(Employee::getDepartment)).entrySet().stream()
						.forEach(e -> System.out.println(e.getKey() + " :: " + e.getValue()));
				;
			}

			private static void avgSalOfMaleAndFemaleEmployees(List<Employee> employeelist) {
		// avgSalOfMaleAndFemaleEmployees(employeelist);
				employeelist.stream()
						.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)))
						.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
			}

			private static void getEmployeesFromSalesAndMarketing(List<Employee> employeelist) {
		// getEmployeesFromSalesAndMarketing(employeelist);
				employeelist.stream().filter(e -> "Sales and Marketing".equalsIgnoreCase(e.getDepartment()))
						.forEach(e -> System.out.println(e));
			}

			private static void mostWorkingExperience(List<Employee> employeelist) {
		// mostWorkingExperience(employeelist);
				System.out.println(employeelist.stream().min(Comparator.comparing(Employee::getYearOfJoining)).get());
			}

			private static void getYoungestEmployee(List<Employee> employeelist) {
		// getYoungestEmployee(employeelist);
				System.out.println(employeelist.stream().min(Comparator.comparing(Employee::getAge)).get());
			}

			private static void deptWiseAvgSalary(List<Employee> employeelist) {
		// deptWiseAvgSalary(employeelist);
				employeelist.stream()
						.collect(
								Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)))
						.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " :: " + e.getValue()));
			}

			private static void countNumberEmpsInDepartment(List<Employee> employeelist) {
		// countNumberEmpsInDepartment(employeelist);
				employeelist.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting())).entrySet()
						.stream().forEach(entry -> System.out.println(entry.getKey() + " :: " + entry.getValue()));
			}

			private static void sortEmployeesBasedOnNameAndSalary(List<Employee> employeelist) {
		//Sort employees based on name and salary
				employeelist.stream().sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary))
						.forEach(e -> System.out.println(e));

				employeelist.sort(Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary));

				employeelist.forEach(e -> System.out.println(e));
			}

			private static void employeesJoinedAfter2015(List<Employee> employeelist) {
		// EmployeesJoinedAfter2015(employeelist);
				employeelist.stream().filter(e -> e.getYearOfJoining() > 2015).forEach(e -> System.out.println(e));
			}

			private static void getHighestPaidEmployees(List<Employee> employeelist) {
		// getHighestPaidEmployees(employeelist);
				Employee e = employeelist.stream().max(Comparator.comparing(Employee::getSalary)).get();
				System.out.print(e);
			}

			private static void getAverageAgeOfEmployee(List<Employee> employeelist) {
		// getAverageAgeOfEmployee(employeelist);
				Double avgSalary = employeelist.stream().collect(Collectors.averagingDouble(Employee::getAge)).doubleValue();
				System.out.println("Average age : " + avgSalary);
			}

			private static void printAllDepartments(List<Employee> employeelist) {
		// printAllDepartments(employeelist);
				employeelist.stream().map(Employee::getDepartment).distinct().forEach(dept -> System.out.println(dept));
			}

			private static void findNoOfMaleAndFemales(List<Employee> employeelist) {
		// findNoOfMaleAndFemales(employeelist);
				employeelist.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting())).entrySet()
						.stream().forEach(e -> System.out.println(e.getKey() + " :: " + e.getValue()));
				;
			}

			private static void extractEmployeeGreaterThanXAmount(List<Employee> employeelist) {
		// ExtractEmployeeGreaterThanXAmount();
		// 10. Employee Salary Greater than X:
		// Given a list of employees (with fields: id, name, salary), find all employees
		// earning more than 50,000.
				employeelist.stream().filter(e -> e.getSalary() > 50000).forEach(e -> System.out.println(e));
	}
}
