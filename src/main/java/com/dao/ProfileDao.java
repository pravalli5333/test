package com.dao;

public class ProfileDao {

	public ProfileDao() {
		String mobile="898989889";
		if(mobile!=null){
			System.out.println("valid");
		}else{
			System.out.println("not valid");
		}
				
		System.out.println("....");
	}

	public void profile() {
		System.out.println("updated");
	}
}
