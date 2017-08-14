package com.shsxt.crm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shsxt.crm.service.CustomerService;
import com.shsxt.crm.vo.CustomerVo;

@Controller
@RequestMapping("customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("find_all")
	@ResponseBody
  public List<CustomerVo> findAll( CustomerVo cvo){
	return  customerService.findAll(cvo);
	
	  
  }
}
