package model;

import java.io.Serializable;
import java.util.Date;

public class Contact implements Serializable{
	private String name, address, phone;
	private Date date;
	
	
	public Contact(String name, String address, String phone){
		this.name = name;
		this.address = address;
		this.phone = phone;
		
		this.date = new Date();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public long getDate() {
		return this.date.getTime();

	}
	
	
}
