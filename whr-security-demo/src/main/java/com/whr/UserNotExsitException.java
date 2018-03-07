package com.whr;

public class UserNotExsitException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5605753918155285638L;

	private String id;
	
	public UserNotExsitException(String id) {
		super("user not exsit...");
		this.id=id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
