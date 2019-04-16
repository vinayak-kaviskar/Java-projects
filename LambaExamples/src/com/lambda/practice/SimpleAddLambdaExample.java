package com.lambda.practice;



@FunctionalInterface
interface MyFunctionalInterface2{
	int add(int a,int b);
}

public class SimpleAddLambdaExample {

	public static void main(String[] args) {
		
		int a =5;
		int b = 6;
		int sum = 0;
		MyFunctionalInterface2 interface2 = (int c,int d)->{
			
			
			return c+d;
			
		};
		
		sum = interface2.add(a, b);
		System.out.println("sum is :"+sum);

	}

}
