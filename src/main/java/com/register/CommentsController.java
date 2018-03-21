package com.register;

public class CommentsController {
	String mobile = "89898989";

	void method() {
		if (mobile != null) {
			System.out.println("mobile no valid");
		} else {
			System.out.println("mobile no not valid");
		}

		System.out.println("hello welcome to comments ");

	}

	public CommentsController() {
		System.out.println("default constructor level");
		System.out.println("zero argument constructor");
	}
}
