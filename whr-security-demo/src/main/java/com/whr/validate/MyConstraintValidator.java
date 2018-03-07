package com.whr.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.whr.service.HelloService;

public class MyConstraintValidator implements ConstraintValidator<MyConstraint, String> {

	@Autowired
	HelloService service;
	
	@Override
	public void initialize(MyConstraint constraint) {
		System.out.println("constraint="+constraint);
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext arg1) {
		System.out.println(value);
		service.sayHello(value);
		return false;
	}
	
}
