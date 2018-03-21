package com.register;

public class CommentsController {
	String name ="Raju";
	void method() {
		if(name != null){
			System.out.println("name valid");
		} else {
			System.out.println("name is invalid");
		}
		System.out.println("hello welcome to comments ");
		
	}
	public CommentsController() {
		System.out.println("default constructor level");
		System.out.println("zero argument constructor");
	}
}
