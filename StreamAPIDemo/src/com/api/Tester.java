package com.api;

import java.net.MulticastSocket;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Tester {
	
	
	public static void main(String[] args) {
		
//		findOnlyEvenNumbers();
//		convertToUpperCase();
		
//		findGreaterElement();
//		PrintWordStartedWithA();
		
		
//
		List<Integer> list = Arrays.asList(8, 4, 1, 9, 4, 8, 3, 6, 1, 5);
//		sumOfEvenNumbers(list);
//		findMiniMumNumber(list);
		
		
//		sumOfSqureOfOddNumbers(list);
//		groupStringByLength();
//		findSecondMaxFromList(list);
//		stringsInReverseOrder();
//		findDuplicatesInList(list);
//
//		capitalizeFirstLetterOfFirstAndLastName();
//		capitalizeFirstLetterOfLastName();
//		capitalizeFirstLetterOfEachWord();
//		findLongestWord();
//		countVowelsAndConsonants();
//		checkStringIsPalindrome();
//		reverseEachWordFromSentence();
//		nonRepeatingCharacter();
		
//		mergeTwoArrays();
//		findMissingNumber();
//		sortStringByLength();
//		commonElementInTwoArray();
//		reverseLinkedList();
//		findIntersectionInTwoArrays();
//		groupAnagramTogether();
		mostFrequentCharacter();
//		sumOfEvenAllNumbers();
//		longestNonRepeatingCharacters();
		
//		longestSubArray("qwerq");
			
	}
	
public static void longestSubArray(String str) {
		
		////qwerq  4

		//qwerqwp

		//qwerqabcded   5
		
/*		int maxLength=0;
		
		for(int i=0;i<str.length();i++) {
			
			Set<Character> set= new HashSet<>();
			
			for(int j=i;j<str.length();j++) {
				char ch=str.charAt(j);
				if(set.contains(ch)) {
					break;
				}
				set.add(ch);
				maxLength=Math.max(maxLength, set.size());
			}
			
			
		}
System.out.println(maxLength);
		*/
	HashMap<Character, Integer> lastSeen = new HashMap<>();
    int maxLen = 0;
    int start = 0;
////qwerq
    for (int end = 0; end < str.length(); end++) { //5,4,3
        char c = str.charAt(end);//w,e,r,q
        if (lastSeen.containsKey(c) && lastSeen.get(c) >= start) {
//        	System.out.println("last c is "+lastSeen.get(c));
            start = lastSeen.get(c) + 1;
        }
        lastSeen.put(c, end);//q,0;w,1;e,2;r,3
        maxLen = Math.max(maxLen, end - start + 1);//0,1;
    }//1,2,3,4

    System.out.println(maxLen);
	
	}
	
	
	public static void longestNonRepeatingCharacters() {
			
		// 20. Find the Longest Substring Without Repeating Characters
				// Question: Write a Java program to find the length of the longest substring
				// without repeating characters.
				// Input: "abcabcbb"
				// Output: 3 (substring is "abc")
				String s = "abcabcbb";
				Set<Character> nonRepeating=new HashSet<>();
				
				int maxSubstring = 0;
				
				for (int i = 0; i < s.length(); i++) {
					if (!nonRepeating.add(s.charAt(i))) {
						if (maxSubstring < nonRepeating.size())
							maxSubstring = nonRepeating.size();

						nonRepeating.clear();

					}
				}

				System.out.println("Longest Substring Without Repeating Characters : " + maxSubstring);
				
				
//				IntStream.range(0, s.length())
//                .boxed()
//                .flatMap(
//                        i -> IntStream.range(i + 1, str.length() + 1)
//                                .mapToObj(
//                                        j -> str.substring(i, j)
//                                )
//                )
//                .filter(
//                        s -> s.chars()
//                              .distinct()
//                              .count() == s.length()
//                )
//                .mapToInt(String::length)
//                .max()
//                .orElse(0);

				
				
				
				
	}
	
	public static void sumOfEvenAllNumbers() {
		
		// 18. Sum of Even Numbers in an Array
				// Question: Write a Java program that calculates the sum of all even numbers in
				// an array.
				// Input: [1, 2, 3, 4, 5, 6]
				List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
//				Integer reduce = list.stream().filter(n->n%2==0)
//						.map(n->n.intValue())
//						.reduce(0,Integer::sum);
				
//				System.out.println(reduce);
				
				int sum=list.stream()
					.filter(n->n%2==0)
					.mapToInt(num->num.intValue())
					.sum();
				
				System.out.println(sum);
					
	}
	
	public static void mostFrequentCharacter() {
		// 17. Find the Most Frequent Character in a String
		// Question: Write a Java program that finds the most frequent character in a
		// string.
		// Input: "aaabbbbcc"
		// Output: "b"
		String str = "aaabbbbccd";
		
		 Character key = str.chars()
				.mapToObj(c->(char)c)
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
				.entrySet().stream()
//				.max(Comparator.comparingDouble(entry->entry.getValue())).get().getKey();
				.max(Comparator.comparingLong(entry->entry.getValue()))
				.get()
				.getKey();
	System.out.println(key);
	
	}
	public static void groupAnagramTogether() {
		
		// 14. Group Anagrams Together
				// Question: Write a Java program to group anagrams from a list of strings.
				// An anagram is a word formed by rearranging the letters of another word.
				// Input: ["eat", "tea", "tan", "ate", "nat", "bat"]
				// Output: [["eat", "tea", "ate"], ["tan", "nat"], ["bat"]]

				List<String> list = Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat");
				
				
				
				 List<List<String>> collect = list.stream()
				.collect(Collectors.groupingBy(
						w->{
							char[] chars=w.toCharArray();
							Arrays.sort(chars);
							return new String(chars);
						}))
				.entrySet().stream()
				.map(entry->entry.getValue())
				.collect(Collectors.toList());
				
				System.out.println(collect);
//				[[eat, tea, ate], [bat], [tan, nat]]

						
				
				
//				for (String word : list) {
//					char[] charArray = word.toCharArray();
//					Arrays.sort(charArray);
//					String sortedWord = new String(charArray);
//					anaMp.putIfAbsent(sortedWord, new ArrayList<String>());
//					anaMp.get(sortedWord).add(word);
//				}
//				System.out.println(anaMp);
//				
//				List<StringBuilder> collect = list.stream()
//							.map(w->{
//								List<Character>str=w.chars().mapToObj(c->(char)c)
//								.sorted()
//								.collect(Collectors.toList());
//								
////								System.out.println(str);
////								List<String>ana1= new LinkedList<>();
//								StringBuilder sb= new StringBuilder();	
//								
//								for(char c:str) {
//									sb.append(c);
//								}
//								System.out.println("w "+w);
//								System.out.println(sb);
//								return sb;
//							})
//							.collect(Collectors.toList());
				
//				.map(w-> new StringBuilder(w).reverse().toString())
				
//				List<String>strList=list.stream().map(w-> new StringBuilder(w).re)
//				L			.forEach(System.out::println);
//				System.out.println(strLiforst);
							
		
		
	}
	
	
	
	public static void findIntersectionInTwoArrays() {
			
		// 13. Find the Intersection of Two Arrays
				// Question: Write a Java program that finds the intersection of two arrays. The
				// intersection should contain only unique elements.
				// Input: [1, 2, 2, 1], [2, 2]
				// Output: [2]
		List<Integer> list1 = Arrays.asList(1, 2, 2, 1, 4, 6, 9, 5);
		List<Integer> list2 = Arrays.asList(2, 2, 5);
		
		list1.stream()
			.filter(list2::contains)
			.distinct()
			.forEach(System.out::println);
		
		//2,5
		
	}
	
	public static void reverseLinkedList() {
			
		// 12. Reverse a Linked List
				// Question: Write a method to reverse a singly linked list in Java.
				// Input: 1 -> 2 -> 3 -> 4
				// Output: 4 -> 3 -> 2 -> 1
				LinkedList<Integer> list = new LinkedList<>();
				list.add(1);
				list.add(2);
				list.add(3);
				list.add(4);
				
				list.stream()
						.sorted(Comparator.reverseOrder())
						.forEach(s->System.out.print(s+"->"));
				//4->3->2->1->
		
	}
	public static void commonElementInTwoArray() {
		
		// 11. Find the Common Elements in Two Arrays
				// Question: Write a Java program that finds the common elements between two
				// arrays.
				// Input: [1, 2, 3, 4], [3, 4, 5, 6]
				// Output: [3, 4]
		
		List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
		List<Integer> list2 = Arrays.asList(3, 4, 5, 6);
		
		list1.stream()
			.filter(list2::contains)
			.forEach(n-> System.out.print(n+" "));
		
		//3 4 
		
	}
	
	public static void sortStringByLength(){
		
		// 10. Sort an Array of Strings by Length
				// Question: Write a Java program that sorts an array of strings by their length
				// in ascending order.
				// Input: ["apple", "banana", "kiwi", "grape"]
				// Output: ["kiwi", "grape", "apple", "banana"]

				List<String> list = Arrays.asList("apple", "bananaa", "kiwi", "grape");
				
//						List<String> collect = list.stream()
//							.collect(Collectors.groupingBy(s->s.length()))
//							.entrySet().stream()
//							.flatMap(entry->entry.getValue().stream())
//							.collect(Collectors.toList());
							
							
//						System.out.println(collect);
				
//						[kiwi, apple, grape, bananaa]
				
				list.stream()
				.sorted(Comparator.comparing(String::length))
				.forEach(s-> System.out.print(s+" "));
							
		
					
	}
	
	
	public static void findMissingNumber() {
		
		// 9. Find the Missing Number in an Array
				// Question: You are given an array of numbers from 1 to N with one number
				// missing. Find the missing number.
				// Input: [1, 2, 4, 5, 6]
				// Output: 3
		//sum=(n*(n+1))/2
				List<Integer> list = Arrays.asList(1, 2, 4, 5, 6);
				
				int n=list.size();
//				System.out.println(n);
				int sum=(n*(n+1))/2;
				int actualSum=0;		
				
				for(Integer num:list) {
					actualSum+=num;
				}
				System.out.println("Missing Number is: "+(actualSum-sum));
						
//				Missing Number is: 3
						
		
	}
	
	
	public static void mergeTwoArrays() {
			
		// 8. Merge Two Sorted Lists
		// Question: Write a Java method that merges two sorted arrays (or lists) into a
		// single sorted array.
		// Input: [1, 3, 5], [2, 4, 6]
		// Output: [1, 2, 3, 4, 5, 6]
		List<Integer> list1 = Arrays.asList(1, 3, 5);
		List<Integer> list2 = Arrays.asList(2, 4, 6);
		
		Stream.concat(list1.stream(), list2.stream())
								.sorted(Integer::compareTo)
								.forEach(num->System.out.print(num+" "));	

			
	}
	
	public static void nonRepeatingCharacter() {
			
		// 7. Find the First Non-Repeating Character in a String
				// Question: Write a Java program to find the first non-repeating character in a
				// string. If there is no non-repeating
				// character, return null.
				// Input: "swiss"
				// Output: "w"

				String s = "swiss";
				
				Optional<Character> ch=s.chars()
						.mapToObj(c-> (char)c)
							.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
							.entrySet()
							.stream()
							.filter(entry-> entry.getValue()<=1)
							.map(e->e.getKey())
							.findFirst();
							
				System.out.println("firstNon repeating charactor is : "+ch.get());
//				firstNon repeating charactor is : w
				
				Map<Character,Integer>mp=new LinkedHashMap<>();
				
				
				for(char c:s.toCharArray()) {
					mp.put(c, mp.getOrDefault(c, 0)+1);
				}
				
				for(Entry<Character,Integer> entry1:mp.entrySet()) {
					if(entry1.getValue()==1) {
						System.out.println("Non repeating By TRADITIONAL WAY: "+entry1.getKey());
						break;
					}
				}
	}
	
	
	public static void reverseEachWordFromSentence() {
		
		// 6. Reverse Each Word in a Sentence
				// Question: Write a Java program that reverses each word in a sentence but
				// keeps the words in the original order.
				// Input: "hello world"
				// Output: "olleh dlrow"

				String s = "hello world";
				
					String collect = Arrays.stream(s.split(" "))
							.map(w-> new StringBuilder(w).reverse().toString())
							.collect(Collectors.joining(" "));
					
					System.out.println(collect);		
//					olleh dlrow
				
		
	}
	
	
	public static void checkStringIsPalindrome() {
		
		// 5. Check if a String is a Palindrome
				// Question: Write a Java program to check if a given string is a palindrome. A
				// palindrome is a word that reads the
				// same backward as forward (ignoring spaces, punctuation, and capitalization).

				String s = "A man a plan a canal Panama";
				
				StringBuilder sb= new StringBuilder(s.replaceAll(" ", "")).reverse();// removed blanks and reversed
				String str= s.replaceAll(" ", "");
				
//				System.out.println(sb);//AmanaplanacanalPanama
//				System.out.println(str);//AmanaplanacanalPanama
				
				if(str.equalsIgnoreCase(sb.toString())) {//ignorecase and toString to convert the stringBuilder to String
					System.out.println("String is Pelindrome "+true);
				}
				else {
					System.out.println("String is NOT Pelindrome "+false);
				}
				
		
	}
	
	
	public static void countVowelsAndConsonants(){
		
//		/ 4. Count Vowels and Consonants in a String
		// Question: Write a Java program that counts the number of vowels and
		// consonants in a given string.
		// Input: "hello world"
		// Output: Vowels: 3, Consonants: 7
		// vowels - aeiou
		String str = "hello world";
				
		Map<String,Integer>map=new LinkedHashMap<>();
			str.chars()
						.mapToObj(c-> (char)c)
						.distinct()
						.forEach(c->{
							List<Character> vowels=Arrays.asList('a','e','i','o','u');
							if(vowels.contains(c.toLowerCase(c))) {
								map.put("vowels",map.getOrDefault("vowels",0)+1);
							}else
							{
								map.put("consonants",map.getOrDefault("vowels",0)+1);
							}
						});
			System.out.println("Vowels "+map.get("vowels"));
			System.out.println("consonants "+map.get("consonants"));
			
	}
	
	public static void findLongestWord() {
		
		
		String s = "I am preparing for the interview";
		
			String string = Arrays.stream(s.split(" "))
					.max(Comparator.comparing(String::length))
					.get();
			
			System.out.println(string);
//			preparing

			
	}
	
	
	public static void capitalizeFirstLetterOfEachWord() {
		
		String str = "hello world from java";
		
				Arrays.stream(str.split(" "))
//					.map(w->w.valueOf(w.substring(0,1)).toUpperCase().concat(w.substring(1,w.length())))
					.map(w->w.substring(0,1).toUpperCase()+w.substring(1,w.length()))
					.forEach(s-> System.out.print(s+" "));
		
	}
	
	public static void  capitalizeFirstLetterOfFirstAndLastName(){
		
		List<String> nameList = Arrays.asList("james bond", "alex jordan", "john smith");
		
				nameList.stream()
					.map(w->{
						
						String[] name=w.split(" ");
						
						String fName=name[0];
						String lName=name[1];
						
						String fullName=fName.substring(0,1).toUpperCase().concat(fName.substring(1,fName.length()))+" "
								+lName.substring(0,1).toUpperCase().concat(lName.substring(1,lName.length()));
						return fullName;
					})
					.forEach(s->System.out.print(s+", "));
				
//				James Bond, Alex Jordan, John Smith, 
				
	}
		
	
	
	public static void capitalizeFirstLetterOfLastName(){
		
		// Question: Write a Java program that capitalizes the first letter of second
				// word in a given name.
				// The name will consist of multiple words separated by spaces.
				// You should preserve the case of the other letters in each word.

				List<String> nameList = Arrays.asList("james bond", "alex jordan", "john smith");
		
				List<String> collect = nameList.stream()
						.map(w->{
							String[] fullName= w.split("\\s");
							String firstname=fullName[0];
							String LastName=fullName[1].substring(0,1).toUpperCase();
							String lastnameFinal=LastName.concat(fullName[1].substring(1,fullName[1].length()));
							
							String fullNameNew= firstname+" ".concat(lastnameFinal);
							return fullNameNew;
						}
						
						).collect(Collectors.toList());
				
				
				System.out.println(collect);
//				[james Bond, alex Jordan, john Smith]
						
		
	}
	public static void findDuplicatesInList(List<Integer>list){
		
		//8, 4, 1, 9, 4, 8, 3, 6, 1, 5
		//o/p 4,8,1
			List<Integer> collect = list.stream()
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
				.entrySet().stream()
				.filter(n->n.getValue()>=2)
				.map(entry->entry.getKey())
				.collect(Collectors.toList());
				
		
		System.out.println(collect);
	}
public static void stringsInReverseOrder(){
	
	String str = "Apple Banana Apple Avocado Cherry";
	
		Arrays.stream(str.split(" "))
//				.distinct()
				.sorted(Comparator.reverseOrder())
				.forEach(s->System.out.print(s+" "));
		
//		Cherry Banana Avocado Apple Apple 
	
	
}
	public static void findSecondMaxFromList(List<Integer>list){
		
		Integer num=list.stream()
			.sorted(Comparator.reverseOrder())
			.skip(1)
			.findFirst()
			.get();
		System.out.println("second largest number: "+num);
//		second largest number: 8
		
	}
	
public static void groupStringByLength() {
		
		String str = "Apple Banana Apple Avocado Cherry";
		
//		Map<String, Long> collect = Arrays.stream(str.split(" "))
//					.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		
//		for(Entry<String,Long> entry:collect.entrySet()) {
//			System.out.println(entry.getKey()+" "+entry.getValue());
//		}
//		System.out.println(collect);
//		{Apple=2, Cherry=1, Avocado=1, Banana=1}
		
		
		Map<Object, List<String>> collect = Arrays.stream(str.split(" "))
//		.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
//		.entrySet().stream()
		.collect(Collectors.groupingBy(e-> e.length()));
		
		System.out.println(collect);

		
}
	
	public static void sumOfSqureOfOddNumbers(List<Integer>list) {
//		List<Integer> list = Arrays.asList(8, 4, 1, 9, 4, 8, 3, 6, 1, 5);
		
		int sumOdd=list.stream()
			.filter(n->n%2!=0)
			.map(num->num*num)//to transform num to square
			.mapToInt(i->i.intValue())
			.sum();
		
		System.out.println("sum of square of odd: "+sumOdd);
//		sum of square of odd: 117
		
	}
	
	public static void findMiniMumNumber(List<Integer>list) {
		
		Integer min=list.stream()
			.min(Integer::compareTo)
			.get();
		System.out.println("min value is: "+min);
//		min value is: 1
	}
	
	public static void sumOfEvenNumbers(List<Integer> list) {
		
		int evenSum=list.stream()
			.filter(n->n%2==0)
			.mapToInt(num->num.intValue())
			.sum();
		
		System.out.println("Sum of even: "+evenSum);
//		Sum of even: 30
		
	}
	
	public static void PrintWordStartedWithA(){
		String str = "Apple Banana Avocado Cherry";
		
			Arrays.stream(str.split(" "))
	               .filter(w->w.toLowerCase().startsWith("a"))
	               .forEach(System.out::println);
			
//			Apple
//			Avocado
			
			
			
// Count the number of strings in a list that start with the letter 'A'.
			// Input: ["Apple", "Banana", "Avocado", "Cherry"]
			// Output: 2
			
			List<String>words=Arrays.asList("Apple", "Banana", "Avocado", "Cherry");
				
			Long count=words.stream()
				.filter(w->w.toLowerCase().startsWith("a"))
				.count();
			System.out.println("count start with A is : "+count);
			
//			count start with A is : 2
	}
	
	
	public static void findGreaterElement() {
		// findGreaterElement();
				List<Integer> list = Arrays.asList(1, 2, 7, 4, 9, 4, 6, 3);
				
				Integer integer = list.stream()
					.max(Integer::compareTo)
					.get();
				System.out.println(integer);
				
				//9
					
				
	}
	
	public static void convertToUpperCase(){
		// convertToUpperCase();
				List<String> strs = Arrays.asList("Raju", "amit", "kumar");
				
				strs.stream()
					.map(s->s.toUpperCase())
					.forEach(s->System.out.print(s+" "));
				//RAJU AMIT KUMAR 
				
				System.out.println(" ");
				
			String statement = "This is java programme";
				Arrays.stream(statement.split(" "))
						.map(s->s.toUpperCase())
						.forEach(s->System.out.print(s+" "));
//				THIS IS JAVA PROGRAMME 
	}
	
	public static void findOnlyEvenNumbers() {
		 
		// findOnlyEvenNumbers();
				List<Integer> list = Arrays.asList(8, 4, 1, 9, 3, 6, 5);
				
					list.stream()	
						.filter(n->n%2==0)
						.forEach(n->System.out.print(n+" "));
					//8 4 6 
		
	}

}
