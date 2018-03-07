package com.whr.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.whr.UserNotExsitException;
import com.whr.dto.User;
import com.whr.dto.UserQuaryCondition;

@RestController
@RequestMapping("/user")
public class UserController {
	@DeleteMapping("/{id:\\d+}")
	@JsonView(User.UserDetailView.class)
	public void delete(@PathVariable String id) {
		System.out.println("dele");
	}
	
	@PutMapping("/{id:\\d+}")
	@JsonView(User.UserDetailView.class)
	public User update(@Valid@RequestBody User user,BindingResult erros) {
		if(erros.hasErrors()) {
			erros.getAllErrors().stream().forEach(erro->System.out.println(erro.getDefaultMessage()));
		}
		System.out.println(user.getBirthday());
		System.out.println("id"+user.getId());
		System.out.println("userName"+user.getUserName());
		System.out.println("password"+user.getPassword());
		user.setId("1");
		return user;
	}
	
	@PostMapping
	@JsonView(User.UserDetailView.class)
	public User create(@Valid@RequestBody User user,BindingResult erros) {
		if(erros.hasErrors()) {
			erros.getAllErrors().stream().forEach(erro->System.out.println(erro.getDefaultMessage()));
		}
		System.out.println(user.getBirthday());
		System.out.println("id"+user.getId());
		System.out.println("userName"+user.getUserName());
		System.out.println("password"+user.getPassword());
		user.setId("1");
		return user;
	}
	
	@GetMapping
	@JsonView(User.UserSimpleView.class)
	public List<User> user(UserQuaryCondition condition,
			@PageableDefault(size=6,page=3,sort="ageTo") Pageable pageable) {
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
//		throw new UserNotExsitException(id);
//		throw new RuntimeException("user not exsit");
		User user=new User();
		user.setUserName("tom");
		user.setPassword("tomPassword");
		return user;
	}
}
