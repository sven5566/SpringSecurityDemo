package com.whr.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
	@Autowired
	private WebApplicationContext wac;
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc=MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void whenQuerySuccess() throws Exception {
		String resultString = mockMvc.perform(get("/user")
				.param("userName", "we")
				.param("age", "15")
				.param("ageTo", "34")
//				.param("size", "4")
//				.param("number", "2")
//				.param("sort", "age DESC")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.length()").value(3))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString()
				;
		System.out.println("result>>>>"+resultString);
	}
	
	@Test
	public void whenGetUserInfoSuccess() throws Exception {
		String resultString = mockMvc.perform(get("/user/1")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.userName").value("tom"))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString()
				;
		System.out.println("result2>>>+"+resultString);
		
	}
	
	@Test
	public void whenGetUserInfoFail() throws Exception {
		mockMvc.perform(get("/user/a")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().is4xxClientError());
		
	}
	
	@Test
	public void whenCreateSuccess() throws Exception{
		Date date=new Date();
//		System.out.println(date.getTime());
//		\"password\":\"tomPassword\",
		String content ="{\"userName\":\"tom\",\"birthday\":\""+String.valueOf(date.getTime())+"\"}";
		mockMvc.perform(post("/user")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(content))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(1));
	}
	
	@Test
	public void whenUpdateSuccess() throws Exception{
		Date date=new Date(LocalDateTime.now().plusYears(1).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
		String content ="{\"userName\":\"tom\",\"birthday\":\""+String.valueOf(date.getTime())+"\"}";
		mockMvc.perform(put("/user/1")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(content))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(1));
	}
	
	@Test
	public void whenDeleteSuccess() throws Exception{
		mockMvc.perform(delete("/user/1")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				;
	}
}
