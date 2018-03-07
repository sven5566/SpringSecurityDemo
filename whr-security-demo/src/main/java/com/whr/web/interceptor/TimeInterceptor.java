package com.whr.web.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class TimeInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HandlerMethod method=(HandlerMethod)handler;
		System.out.println("preHandle"+method.getBean().getClass().getName());
		System.out.println("method"+method.getMethod().getName());
		long start=new Date().getTime();
		request.setAttribute("startTime", start);
		System.out.println("preHandle");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		long start=(long) request.getAttribute("startTime");
		System.out.println("postHandle,耗时"+(new Date().getTime()-start));
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long start=(long) request.getAttribute("startTime");
		System.out.println("afterCompletion,耗时"+(new Date().getTime()-start));
		System.out.println("exception,耗时"+ex);
	}

}
