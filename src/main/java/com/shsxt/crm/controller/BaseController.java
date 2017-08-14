package com.shsxt.crm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.shsxt.crm.constant.Constant;
import com.shsxt.crm.exception.ParamException;
import com.shsxt.crm.model.ResultInfo;

public class BaseController {
	
	@ModelAttribute
	protected void preMethod(HttpServletRequest request, Model model) {
		String ctx = request.getContextPath();
		model.addAttribute("ctx", ctx);
	}
	protected ResultInfo failure(Integer errorCode, String errorMessage) {
		ResultInfo result = new ResultInfo(errorCode, errorMessage, errorMessage);
		return result;
	}
	
	protected ResultInfo failure(String errorMessage) {
		ResultInfo result = failure(Constant.ERROR_CODE, errorMessage);
		return result;
	}
	
	protected ResultInfo failure(ParamException exception) {
		ResultInfo result = failure(exception.getCode(), exception.getMessage());
		return result;
	}
	
	protected ResultInfo success(Object result) {
		ResultInfo resultInfo = new ResultInfo(Constant.SUCCESS_CODE, Constant.SUCCESS_MSG, result);
		return resultInfo;
	}
	
}
