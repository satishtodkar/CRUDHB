package com.codemind.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Studenti")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long rollno;
	@Column(name = "name")
    private String name;
	@Column(name = "emailId")
	private String emailId;
	@Column(name = "mobile")
	private String mobile;
	@Column(name = "city")
	private String city;
	/*
	 * 
	 * public Student(long rollno, String name, String emailId, String mobile,
	 * String city) { super(); this.rollno = rollno; this.name = name; this.emailId
	 * = emailId; this.mobile = mobile; this.city = city; }
	 */

	public Student(String string, String name2, String emailId2, String mobile2, String city2) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.emailId = emailId;
		this.mobile = mobile;
		this.city = city;
	}

	public long getRollno() {
		return rollno;
	}

	public void setRollno(long rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
