package com.hbsi.interceptor;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hbsi.dao.root.RootDao;

public class TokenInterceptor implements HandlerInterceptor{

	@Autowired
	RootDao rootDao;
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("token拦截器--------------------");
		Cookie[] cookies = request.getCookies();
		String token = null;
		String root_uname = null;
		String root_pwd = null;
		if (cookies == null ) {
			return false;
		}
		else {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("token")) {
					token = cookie.getValue();
				}
				if (cookie.getName().equals("root_uname")) {
					root_uname = cookie.getValue();
				}
				if (cookie.getName().equals("root_pwd")) {
					root_pwd = cookie.getValue();
				}
			}
			if (token == null) {
				return false;
			}else {
				System.out.println(token);
				Map<String, String> root = rootDao.queryrootBtoken(token);
				if (root == null) {
					return false;
				}
				if (root_pwd.equals(root.get("root_pwd")) && root_uname.equals(root.get("root_uname")) && token.equals(root.get("token"))) {
					return true;
				}
				else {
					return false;
				}
			}
			
		}
		
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
