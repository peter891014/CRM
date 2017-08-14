package com.shsxt.crm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shsxt.crm.dao.CustomerDao;
import com.shsxt.crm.vo.CustomerVo;

@Service
public class CustomerService {
	@Resource
  private CustomerDao customerDao;
	
	public List<CustomerVo> findAll(CustomerVo cvo) {
		
		return 	customerDao.findAll();
	}

}
