package com.whr.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.whr.UserNotExsitException;

/**
 * 自定义异常处理
 * @author whrr5
 */
@ControllerAdvice
public class ControllerExceptionHandler {
	@ExceptionHandler(UserNotExsitException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Map<String, Object> handleUserNotExsitException(UserNotExsitException exception) {
		Map<String, Object> result = new HashMap<>();
		result.put("id", exception.getId());
		result.put("message", exception.getMessage());
		return result;
	};
}
