package com.lambda.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class MyEmployee {

	private int age;
	private String name;

	public MyEmployee(int age, String name) {

		this.age = age;
		this.name = name;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "MyEmployee [age=" + age + ", name=" + name + "]";
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

public class ComparatorUsingLambdaExpression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<MyEmployee> list = new ArrayList();
		list.add(new MyEmployee(28, "SHaam"));
		list.add(new MyEmployee(12, "Chinmay"));
		list.add(new MyEmployee(76, "bingooo"));

		System.out.println(list);
		Collections.sort(list, (name1, name2) -> {

			return name1.getName().compareTo(name2.getName());
		});

		System.out.println(list);
		
		
		
		Stream<MyEmployee> filterdStream =  list.stream().filter(predicate -> predicate.getAge()>12);
		
		filterdStream.forEach(action->{
			System.out.println(action);
		});

	}

}
