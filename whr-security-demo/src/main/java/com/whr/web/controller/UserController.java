package com.whr.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.whr.dto.User;
import com.whr.dto.UserQuaryCondition;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@GetMapping
	@JsonView(User.UserSimpleView.class)
	public List<User> user(UserQuaryCondition condition,@PageableDefault(size=6,page=3,sort="ageTo") Pageable pageable) {
		System.out.println(""+pageable.getPageSize());
		System.out.println(""+pageable.getPageNumber());
		System.out.println(""+pageable.getSort());
		System.out.println(""+condition);
		List<User>result=new ArrayList<User>();
		for(int i=0;i<3;i++) {
			User bean=new User();
			result.add(bean);
		}
		return result;
	}
	
	@GetMapping(value="/{id:\\d+}")
	@JsonView(User.UserDetailView.class)
	public User getInof(@PathVariable String id) {
		User user=new User();
		user.setUserName("tom");
		user.setPassword("tomPassword");
		return user;
	}
}
