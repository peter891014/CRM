package com.shsxt.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shsxt.crm.constant.Constant;
import com.shsxt.crm.exception.ParamException;
import com.shsxt.crm.model.ResultInfo;
import com.shsxt.crm.model.User;
import com.shsxt.crm.service.UserService;
import com.shsxt.crm.vo.UserLoginIdentify;

@Controller
@RequestMapping("user")
public class UserController  extends BaseController{
	@Autowired
	private UserService userService;

	@RequestMapping("login")
	@ResponseBody
	public ResultInfo login(String userName, String password) {
		ResultInfo result =null;
		try {
			UserLoginIdentify  uli = userService.find(userName, password);
			 result=success(uli);
		} catch (ParamException e) {
		result = new ResultInfo(Constant.ERROR_CODE, e.getMessage(), "操作失败");
		result = failure(e);
		}
	
		return result;
	}
	@RequestMapping("find_customer_manager")
	@ResponseBody
	public List<User> find_customer_manager(){
		
		return userService.find_customer_manager();
		
		
	}
}
