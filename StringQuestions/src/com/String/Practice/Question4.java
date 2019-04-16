package com.String.Practice;

public class Question4 {

	// reverse a string
	
	
	// learnings:
	 //1. We can use stringBuffer to reverse a string
	// 2. We can use nested function method to reverse a string
	// 3. We can use reverse array method by loop to reverse a string
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String temp = "HELLO MOTO";

		
		// Approach 1
		char orderedcharacters[] = temp.toCharArray();
		char reversedCharacters[] = new char[orderedcharacters.length];
		for (int i = orderedcharacters.length - 1; i >= 0; i--) {
			reversedCharacters[(orderedcharacters.length-1) - i] = orderedcharacters[i];
		}
		System.out.println(new String(reversedCharacters));
		
		
		
		//Approach 2
		
		StringBuilder buffer = new StringBuilder(temp);
		String reversedString = new String(buffer.reverse());
		System.out.println("reversed using buffer:"+reversedString);
		
		
		
		//Approach 3
		System.out.println("By recusive method :"+recursiveMethod(temp));
		
	}
	
	static String recursiveMethod(String str) {
		
	/*	This method takes the first character of a string (str.charAt(0)) 
		and puts it at the end of the string. And then calls itself on the 
		remainder of the string (str.substring(1)). Finally adds these two things 
		to get the reverse of the passed string (recursiveMethod(str.substring(1)) + str.charAt(0)). 
		When the passed string is one character or less (str.length() <= 1), it stops calling itself 
		and just returns the string passed.*/
		
		
		
		if(str.length()<=1 || str == null)
			return str;
		return  recursiveMethod(str.substring(1)) + str.charAt(0);
	}

}
