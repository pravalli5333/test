package com.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="proorder")
public class Ordered {
	
	@Id
	@GeneratedValue
	@Column(name="Itemid")
	private String itemid;
	
	@Column(name="ItemName")
	private String itemname;
	
	@Column(name="Weight")
	private String weight;
	
	@Column(name="Currentcity")
	private String currentcity;
	
	@Column(name="Tocity")
	private String tocity;
	
	@Column(name="Price")
	private String price;

	public String getItemid() {
		return itemid;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getCurrentcity() {
		return currentcity;
	}

	public void setCurrentcity(String currentcity) {
		this.currentcity = currentcity;
	}

	public String getTocity() {
		return tocity;
	}

	public void setTocity(String tocity) {
		this.tocity = tocity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

		
}