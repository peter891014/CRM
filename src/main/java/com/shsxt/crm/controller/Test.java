package com.shsxt.crm.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class Test {
    @RequestMapping("test")
	public Map<String,Object> test(){
		Map  <String,Object> map= new HashMap <String,Object>();
		map.put("resultCode", 1);
		map.put("resultMessage", "Success");
		return map;
		
	}
}
