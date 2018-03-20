package com.dao;

import java.util.List;

import com.pojo.Customers;

public interface IRegisterDao {

	public void details(Customers customers);

	public void updateCust(Customers cust);

	public List<Customers> getCustomers();

	public void deleteRow(Customers customer);
	
}
