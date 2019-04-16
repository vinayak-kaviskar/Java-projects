package com.lambda.practice;

interface MyFunctionalInterface {

	void test();

}

public class LambdaVsAnonymous {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// using Anonymous Class concept to implement functional interfaces
		MyFunctionalInterface myInterface = new MyFunctionalInterface() {

			@Override
			public void test() {
				System.out.println("This is an anonymous class method");

			}
		};
		myInterface.test();
		
		//  With using lambda expression to implement functional interface
		MyFunctionalInterface myInterface2 = () -> {
			System.out.println("This is from lambda implementation of test method");
		};
		myInterface2.test();

	}

}
