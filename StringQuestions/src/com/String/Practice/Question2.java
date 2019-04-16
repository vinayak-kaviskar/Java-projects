package com.String.Practice;

public class Question2 {

	
	
	// How do you remove all white spaces from a string in java?
	
	// solved by 2 options :loop and replace using regex
	// \\s and \\s+ are from regex  
	// \t and ' ' are space characters while using loop methos
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String temp = "helllo moto  motoo";
		
		// options with using libraries
		temp = temp.replaceAll("\\s","");
		
		
		// below option is more faster as it replaces all the spaces at same time
		temp = temp.replaceAll("\\s+","");
		System.out.println(temp);
		
		
		String temp2  = "bingo	helllo moto  motoo";
		
		StringBuilder buffer = new StringBuilder();
		char myCharArray[] = temp2.toCharArray();
		
		
		for(char singleChar : myCharArray) {
						
			/*if(singleChar == '\t')
				System.out.println("tab found");*/
			
			if(singleChar != ' ' && singleChar !='\t' )
			buffer.append(singleChar);
			
		}
		
		System.out.println(buffer.toString());

	}

}
