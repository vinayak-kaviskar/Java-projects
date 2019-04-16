package com.String.Practice;

import java.util.HashMap;
import java.util.HashSet;

public class Question3 {
	
	//Write a java program to find duplicate characters and their count in a given string? 
	// used hashset to save unique characters
	// used hashmap to find count of repeated characters

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String temp = "aabbbcccnhjkl";
		

		HashSet<Character> uniqueChars = new HashSet<Character>();
		HashSet<Character> duplicateChars = new HashSet<Character>();
		HashMap<Character, Integer> duplicateCharsWithCount = new HashMap<Character,Integer>();

		char[] characterArray = temp.toCharArray();

		for (Character testChar : characterArray) {

			if (!uniqueChars.contains(testChar)) {
				uniqueChars.add(testChar);
			}
			if (duplicateCharsWithCount.containsKey(testChar)) {

				duplicateCharsWithCount.put(testChar, duplicateCharsWithCount.get(testChar) + 1);

			} else {
				duplicateCharsWithCount.put(testChar, 1);
			}
		}
		System.out.println("All chars:" + uniqueChars.toString());
		System.out.println(" chars count: " + duplicateCharsWithCount.toString());
		
		uniqueChars.forEach(action ->{
			
			if(duplicateCharsWithCount.get(action)>1)
			duplicateChars.add(action);
			
		});
		System.out.println("Only repeated chars are: "+duplicateChars.toString());

	}

}
