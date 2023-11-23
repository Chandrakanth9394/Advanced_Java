package com.student;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pan {
	@Id
	private int id;
	private int panno;
	private String address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPanno() {
		return panno;
	}

	public void setPanno(int panno) {
		this.panno = panno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
