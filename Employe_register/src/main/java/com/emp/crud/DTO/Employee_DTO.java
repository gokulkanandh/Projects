package com.emp.crud.DTO;

public class Employee_DTO 
{

	private int Id;
	private String Name;

	private String Password;
	private String Email;
	private String  State;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
}
