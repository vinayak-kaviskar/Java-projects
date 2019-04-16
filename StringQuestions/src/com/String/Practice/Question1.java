package com.String.Practice;

import java.util.HashMap;

public class Question1 {
	
	
	
	//How do you count the number of occurrences of each character in a string?
	
	
	//learnings  :
	   // 1.  We cannot add primitive data type in hashmap nor as key nor as values

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		String temp1 = "aaabbcccdddd";
		
		
	HashMap<Character,Integer>  myMap = new HashMap();
		
			char charArray[] = temp1.toCharArray();
			
			for(char charat : charArray) {
				
				if(myMap.containsKey(charat)) {
					
					myMap.put(charat, myMap.get(charat)+1);
					
				}
				else {
					myMap.put(charat,1);
				}
			}
			
			System.out.println(myMap);
	}

}
