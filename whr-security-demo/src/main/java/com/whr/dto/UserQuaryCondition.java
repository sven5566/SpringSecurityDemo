package com.whr.dto;

public class UserQuaryCondition {
	private String userName;
	private int age;
	private int ageTo;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAgeTo() {
		return ageTo;
	}
	public void setAgeTo(int ageTo) {
		this.ageTo = ageTo;
	}
	@Override
	public String toString() {
		return "UserQuaryCondition [userName=" + userName + ", age=" + age + ", ageTo=" + ageTo + "]";
	}
	
	
}
