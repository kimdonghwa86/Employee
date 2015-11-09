package com.hybrid.model;

import java.util.Date;
import com.hybrid.exception.PasswordNotMatchingException;

/*
 * Model Object
 * Value Object
 * Transfer Object
 * Beans 1. property ==> setter, getter 
 * 		 2. event
 * 		 3. 기능(method)
 */

public class Member { 
	private long id;          //private는 나만 접근할수있도록 만들겠다.  
	private String email;
	private String name;
	private String password;
	private Date registerDate;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	
	public void changePassword(String oldPassword, String newPassword) {        //패스워드를 바꾸는 기능
		if (!this.password.equals(oldPassword)){							//원래패드워드가 같아야한다.
			throw new PasswordNotMatchingException();                            //에러일때 수행된다.
		}
		this.password = newPassword;
	}
	
	
	
	
}
