package com.sl.model;

public class User {	
	private String login;
	private String password;
	private static String nameForm;
	
	
	public String getLogin() {
		return login;
	}
	public User setLogin(String login) {
		this.login = login;
		return this;
	}	
	
	public String getPassword() {
		return password;
	}
	public User setPassword(String password) {
		this.password = password;
		return this;
	}
	public static String getNameForm() {
		return nameForm;
	}
	public static void setNameForm(String name) {
		nameForm = name;
	}	

}
