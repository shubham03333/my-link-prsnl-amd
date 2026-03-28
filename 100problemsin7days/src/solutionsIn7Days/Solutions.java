package solutionsIn7Days;
import java.util.Scanner;


public class Solutions {
	
	public static void main(String []args) {
		
		
		Scanner sc= new Scanner(System.in);
		//print value till n
		System.out.println("Enter the value of n: ");
//		printTillN(sc.nextInt());
		
		//Reverse the number till 1
//		reverseTillN(sc.nextInt());
		
		//sum of 1 to n
//		sum1ToN(sc.nextInt());
		
//		even or odd
		evenOdd(sc.nextInt());
		
		
	}
	
	
	public static void printTillN(int n) {
		
		for(int i=1;i<=n;i++) {
			System.out.print(i+", ");
		}
	}
	
	public static void reverseTillN(int n) {
		
		for(int i=n;i>=1;i--)
			System.out.print(i+",");
	}
	
	public static void sum1ToN(int n) {
		
		int sum=0;
		for(int i=1;i<=n;i++) {
			sum+=i;
		}
		System.out.println("sum= "+sum);
	}
	
	public static void evenOdd(int n) {
		
		if(n%2==0) {
			System.out.println(n+" is Even number.");
		}else {
			System.out.println(n+" is ODD number.");
		}
	}

}
