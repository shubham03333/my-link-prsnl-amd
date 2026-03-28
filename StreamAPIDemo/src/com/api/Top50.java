package com.api;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;




class ListNodeNew{
	
	 int val;
	 
	 ListNodeNew next;
	 
	 public ListNodeNew(int val)
	 {
		 this.val=val;
	 }
}


public class Top50 {

	public static void main(String[] args) 
	{
	
		
		int [] arr= {2,7,11,15};
		int target=9;
		int [] indexes=twoSum(arr, target);
//		System.out.println(indexes[0]+" "+indexes[1]);
		
		//max nonrepeating character substring
		
//		System.out.println(lengthOfLongestSubstring("abcdadbcgda"));
		
//		System.out.println(isAnagram("madam", "madam"));
		
		
		String[] strs={"aet","eat","tea", "ate","ant","tan"};
		
//		groupAnagrams(strs);
		
//		reverseString();
		
//		stringCompress();
		
//		System.out.println(checkPelindrome("Madam"));
		
//		System.out.println(firstNonRepeat("aabbcdde"));
		
//		System.out.println(getFrequency("Hello World"));
		
//		getFrequencyByStream("Hello World");
		
		//
		
		ListNodeNew head= new ListNodeNew(1);
		
		head.next=new ListNodeNew(2);
		head.next.next=new ListNodeNew(3);
		
//		printList(reverseList(head));
		printAnagram();
		
	}

	
	
//	Time: O(n)
//	Space: O(n)
		
	public static int [] twoSum(int [] nums, int target) 
	{
		
		Map<Integer,Integer>map= new HashMap<>();
		
		for(int i=0;i<nums.length;i++) 
		{
			
			int complement=target-nums[i];
			if(map.containsKey(complement)) 
			{
				return new int [] 
				{
					map.get(complement), i
				};
			}
			map.put(nums[i], i);
		}
		
		return new int [] {-1,-1};
	}
	
	
	public static int lengthOfLongestSubstring(String s) 
	{
		
		Set<Character> set= new HashSet<>();
		int left=0,max=0;
		
		for(int right=0;right<s.length();right++) 
		{
			
			while(set.contains(s.charAt(right))) 
			{
				set.remove(s.charAt(left++));
			}
			
			set.add(s.charAt(right));
			
			max=Math.max(max, right-left+1);
		}
		
		return max;
		
	}
	
	
	//Valid Anagram (Stream)
	
	public static boolean isAnagram(String s, String t) 
	{
		
		return s.length()==t.length() &&
				s.chars().sorted().boxed().collect(Collectors.toList())
				.equals(t.chars().sorted().boxed().collect(Collectors.toList()));
	}
	
	//o(n log n)
	
	
	public static void groupAnagrams(String[] strs)
	{
		
		Map<String,List<String>> map=new HashMap<>();
		
		for(String s:strs)
		{
			char[] arr=s.toCharArray();
			Arrays.sort(arr);
			String key= new String(arr);
			
			map.computeIfAbsent(key, k-> new ArrayList<>()).add(s);
		}
		
		
		System.out.println(new ArrayList<>(map.values()));
//		return new ArrayList<>(map.values());
		
	}
	
	public static void reverseString() 
	{
		String str="shubham";
		String reversed="";
		
		StringBuilder sb= new StringBuilder();
		
		for(int i=str.length()-1;i>=0;i--) 
		{
			
			reversed+=str.charAt(i);
			
		}
		
//		System.out.println(reversed);
//		String letter= str.chars()
//							.filter(Character::isLetterOrDigit)
//							.mapToObj(c->(char)c)
//							.map(String::valueOf)
//							.collect(Collectors.joining());
//		System.out.println(letter);
		
		System.out.println(IntStream.range(0, str.length())
		.mapToObj(i->String.valueOf(str.charAt(str.length()-i-1)))
		.collect(Collectors.joining()));
		

		
		
//		System.out.println(new StringBuilder(str).reverse().toString());
		
				
	}
	
	public static void stringCompress() 
	{
		String str="aaabbcdeff";
		
		if(str==null || str.length()<=2)
		{
			System.out.println("String is empty");
		}
		
		StringBuilder compressed= new StringBuilder();
		
		int count=0;
		
		for(int i=0;i<str.length();i++) 
		{
			
			count++;
			
			if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1))
			{
				compressed.append(str.charAt(i));
				compressed.append(count);;
				count=0;
			}
			
		}
		
//			System.out.println(compressed.length() < str.length() ? compressed.toString():str);
		System.out.println("str length "+str.length());
		System.out.println("compressed length "+compressed.length());
		System.out.println(compressed);
		
	}
	
	public static boolean checkPelindrome(String str) 
	{

		int left=0, right=str.length()-1;
		
		while(left<right) 
		{
			if(str.charAt(left++) != str.charAt(right--))
			{
				return false;
			}
		}
		
		return true;
			
	}
	
	
	public static char firstNonRepeat(String s)
	{
		
		Map<Character,Integer> map=new LinkedHashMap<>();
		
		for(char c:s.toCharArray())
		{
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		for(Map.Entry<Character, Integer> e : map.entrySet())
		{
			if(e.getValue()==1)
			{
				return e.getKey();
			}
		}
				
		return '_';
	}
	
	
	//Character Frequency
	public static Map<Character,Integer> getFrequency(String str)
	{
		
			Map<Character,Integer>frequencyMap= new HashMap<>();
			
			for(char ch :str.toCharArray())
			{
				frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0)+1);
			}
			
			return frequencyMap;
			
			
	}
	
	//Character Frequency using Stream
	public static void getFrequencyByStream(String str) 
	{
		
			str.chars()
					.mapToObj(c-> (char)c)
					.collect(Collectors.groupingBy(c->c,Collectors.counting()))
					.entrySet().stream()
					.forEach(entry->System.out.println(entry.getKey()+" : "+entry.getValue()));
	}

	
	public static ListNodeNew reverseList(ListNodeNew head) 
	{
		
		ListNodeNew prev=null;
		
		while(head!=null) 
		{
			
			ListNodeNew next=head.next;
			
			head.next=prev;
			prev=head;
			head=next;
			
		}
		
		return prev;
	}
	//Time: O(n)
	
	
	public static void printList(ListNodeNew node)
	{
		while(node!=null)
		{
			System.out.print(node.val+" -> ");
			node=node.next;
		}
		
	}
	
	//4. Detect Cycle in Linked List
	
	

	public static void printAnagram()
	{
		List<String> list = Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat");
		
					list.stream()
							.collect(Collectors.groupingBy(
								w->{
										char[] ch= w.toCharArray();
										Arrays.sort(ch);
										return new String(ch);
									}))
							.entrySet().stream()
							.forEach(s->System.out.print(s));
					//aet=[eat, tea, ate]abt=[bat]ant=[tan, nat]
							
	}
	
}
