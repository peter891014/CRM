package com.shsxt.crm.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shsxt.crm.util.CookieUtil;

@Controller
public class IndexController {
	
	@RequestMapping("index")
	public String index(HttpServletRequest request,Model model){
		String ctx =request.getContextPath();
		model.addAttribute("ctx",ctx);
		return "index";
	}
	
	@RequestMapping("main")
	public String main(HttpServletRequest request,Model model){
		String ctx =request.getContextPath();
		model.addAttribute("ctx",ctx);
	     String userName=CookieUtil.getCookieValue(request, "userName");
	     String realName=CookieUtil.getCookieValue(request, "realName");
	     model.addAttribute("userName",userName);
	     model.addAttribute("realName",realName);
		return "main";
	}
}
