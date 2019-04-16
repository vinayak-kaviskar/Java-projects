package com.lambda.practice;

public class ThreadUsingLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Runnable r1 = () -> {

			System.out.println("Task in thread using lambda expression:" + Thread.currentThread().getName());

		};
		Thread t1 = new Thread(r1);

		t1.start();

	}

}
