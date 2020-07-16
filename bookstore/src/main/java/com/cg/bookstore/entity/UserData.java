package com.cg.bookstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="userdetails")
public class UserData
{
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	//@Column(name = "user_id")
    private int userid;
	@Column(name="email",length=54)
    private String email;
	@Column(name="firstname",length=22)
    private String firstName;
	@Column(name="password",length=8)
    private String password;
public UserData() {
}
       public UserData(int userid, String email, String firstName, String password) {
		super();
		this.userid = userid;
		this.email = email;
		this.firstName = firstName;
		this.password = password;
	}
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
       
}



