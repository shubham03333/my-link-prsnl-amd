package com.api;
import java.util.*;
import java.util.stream.Collectors;


class ListNode{
	
	 int val;
	
	ListNode next;
	
	public ListNode(int val) {
		this.val=val;
	}
}

public class ImpCodes {

	public static void main(String[] args) {
		
		//kadens algorithm
		int [] arr= {-2,1,-3,4,-1,2,1};
//		System.out.println(maxSubArray(arr));
		
		//Two Sum
		
		int [] nums= {2,7,11,15};
		int target=9;
		
//		int[] result=twoSum(nums, target);
//		System.out.println(result[0]+" "+result[1]);
		//0 1
		
		//Valid Parenthesis 
		String str="({[]})";
//		System.out.println(isValid(str));
		
		//Reverse linkedList
		
		// 1. Create a list: 1 -> 2 -> 3
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

//        System.out.print("Original: ");
//        printList(head);

        // 2. Run your method
//        ListNode reversedHead = reverseLinkedListItr(head);
     
//        System.out.print("Reversed: ");
//        printList(reversedHead);
        
     // Calling the recursive method
        ListNode reversedHead = recursiveReverseLinkedList(head);

//        System.out.print("Recursively reversed: ");
//        printList(reversedHead);
   
        
		
//		System.out.println(reverseLinkedListItr(1));
        
        meargeAnagram();
	}
	
	
	
	public static void meargeAnagram() {
		
		List<String> list = Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat");
		
				list.stream()
					.collect(Collectors.groupingBy(
							w->{
								char[] ch=w.toCharArray();
								Arrays.sort(ch);
								
								return new String(ch);
							}
							))
					.entrySet().stream()
					.forEach(s->System.out.print(s));
				
				
//				.forEach(System.out::println);
		
	}
	
	
	//kadens algorithm --> find maximum sum from array
	//negative sum useless drop it 
	//posiive sum extend
	
	
	/*Given an integer array nums, find the contiguous subarray (containing at least one number) 
	 * which has the largest sum and return its sum.

			Example 1:

			Input: nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]

			Output: 6

			Explanation: The contiguous subarray [4, -1, 2, 1] has the largest sum = 6.*/
	
	public static int maxSubArray(int nums []) {
			
		int currSum=nums[0];
		int maxSum=nums[0];
		
		
		for(int i=1;i<nums.length;i++) {
			
			currSum=Math.max(nums[i], currSum+nums[i]);
			maxSum=Math.max(maxSum, currSum);
		}
		
		
		return maxSum;
	}
	
	//Two Sum
	
	public static int [] twoSum(int []nums, int target) {
		
		Map<Integer, Integer>map= new HashMap<>();
		
		for(int i=0;i<nums.length;i++) {
			
			int complement=target-nums[i];
			if(map.containsKey(complement)) {
				return new int[] {
						map.get(complement),i
				};
			}
			
			map.put(nums[i], i);
		}
		
		return new int [] {-1, -1};
	}
	
	
	//Parenthesis
	
	public static boolean isValid(String str) {
			
		Stack<Character> stack= new Stack<>();
		
		for(char ch:str.toCharArray()) {
			
			if(ch=='('||ch=='{'||ch=='[') {
				stack.push(ch);
			}else {
				if(stack.isEmpty()) {
					return false;
				}
				
				char top=stack.pop();
				
				if( (ch==')' && top!='(') ||
					(ch=='}' && top!='{')||
					(ch==']' && top!='[') 
						) {
					return false;
				}
			}
		}
		
		return stack.isEmpty();
		
	}
	
	//reverse the linkedList
	
	public static ListNode reverseLinkedListItr(ListNode head ) {
		
		//1->2->3
		//3<-2<-1
		ListNode curr=head;
		ListNode prev=null;
		while(curr!=null) {
			
			ListNode next=curr.next;//2,3,null
			
			curr.next=prev;//null,1,2
			prev=curr;//1,2,3
			curr=next;//2,3,null
		}
		
		return prev;
		
	}
	
	public static ListNode recursiveReverseLinkedList(ListNode head) {
		
		if(head==null || head.next==null) {
			return head;
		}
		
		ListNode newHead=recursiveReverseLinkedList(head.next);
		
		head.next.next=head;
		head.next=null;
		
		return newHead;
	}
	
	public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + (node.next != null ? " -> " : ""));
            node = node.next;
        }
        System.out.println();
    }
	

}
