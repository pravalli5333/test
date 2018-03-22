package com.dao;

public class ProfileDao {

	public ProfileDao() {
		String mobile="898989889";
		if(mobile!=null){
			System.out.println("valid");
		}else{
			System.out.println("not valid");
		}
				
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
