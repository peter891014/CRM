package com.shsxt.crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.shsxt.crm.vo.CustomerVo;

public interface CustomerDao {
    
	@Select("SELECT id, name FROM t_customer where is_valid = 1")
	public  List <CustomerVo>findAll() ;
  
}
