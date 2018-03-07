package com.whr.dto;

import java.util.Date;

import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonView;
import com.whr.validate.MyConstraint;

public class User {
	public interface UserSimpleView{};
	public interface UserDetailView extends UserSimpleView{};
	private String id;
	@MyConstraint
	private String userName;
	@NotBlank(message="密码不能为空")
	private String password;
	@Past(message="生日必须是过去")
	private Date birthday;
	@JsonView(UserSimpleView.class)
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@JsonView(UserSimpleView.class)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@JsonView(UserSimpleView.class)
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@JsonView(UserDetailView.class)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + "]";
	}
}
