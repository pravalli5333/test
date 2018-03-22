package com.dao;

public class ProfileDao {

	public ProfileDao() {
		String name="Yash";
		if(name != null) {
			System.out.println("name is valid");
		} else {
			System.out.println("name is invalid");
		}
		System.out.println("....");
	}

	public void profile() {
		System.out.println("updated");
	}
}
