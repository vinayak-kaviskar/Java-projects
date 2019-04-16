package com.lambda.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LambaListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> list = new ArrayList();

		list.add("Strin1");
		list.add("Strin2");
		list.add("Strin3");
		list.add("Strin4");
		list.add("Strin5");
		list.add("Strin6");
		list.add("Strin7");

		
		System.out.println("using for-each method to iterate a list");
		
		// for each method is a default method of iterable interface
		list.forEach(action -> {

			System.out.println(action);

		});
		
		
	Iterator<String> itr = list.iterator();
	
	System.out.println("using for-each-remaining method to iterate a list");
	
	// for each method remaining is a default method of iterator interface
	itr.forEachRemaining(action2 ->{
		
		System.out.println(action2);
	});
	

	}

}
