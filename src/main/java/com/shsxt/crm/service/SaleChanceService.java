package com.shsxt.crm.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;
import com.shsxt.crm.dao.SaleChanceDao;
import com.shsxt.crm.dto.SaleChanceQuery;
import com.shsxt.crm.model.SaleChance;
import com.shsxt.crm.util.AssertUtil;

@Service
public class SaleChanceService {
     @Resource
	private SaleChanceDao saleChanceDao;
	public Map<String, Object> find(SaleChanceQuery saleChanceQuery) {
		Integer page=saleChanceQuery.getPage();
		if(page==null){
			page=1;
		}
		Integer pageSize=saleChanceQuery.getRows();
		if(pageSize==null){
			pageSize=10;
		}
		String sort =saleChanceQuery.getSort();
		if(StringUtils.isBlank(sort)){
			sort="id.desc";
		}
		PageBounds pageBounds = new PageBounds(page, pageSize, Order.formString(sort));
		
		
		
		List <SaleChance> saleChances=saleChanceDao.findForPage(saleChanceQuery,pageBounds);
		PageList <SaleChance> result =(PageList<SaleChance>) saleChances;
		Paginator paginator = result.getPaginator();
		Map<String, Object> map = new HashMap<>();
		map.put("paginator", paginator);
		map.put("rows", result);
		map.put("total", paginator.getTotalCount());
		
		return map;
	}
	public void insertSaleChance(SaleChance saleChance) {
		//saleChance 的参数验证
		paramsCheck(saleChance);
		saleChance.setIsValid(1);
		String assignMan = saleChance.getAssignMan();
		int state = 0; // 未分配
		Date assignTime = null;
		if (StringUtils.isNotBlank(assignMan)) {
			state = 1; // 已分配
			assignTime = new Date();
		}
		saleChance.setState(state);
		saleChance.setAssignTime(assignTime);
		saleChanceDao.insertSaleChance(saleChance);

		
	}
	private void paramsCheck(SaleChance saleChance) {
		// TODO Auto-generated method stub
		System.out.println("id:"+saleChance.getCustomerId());
		System.out.println("name:"+saleChance.getCustomerName());
		AssertUtil.notNull(saleChance.getCustomerId(), "请选择客户id");
		AssertUtil.isNotEmpty(saleChance.getCustomerName(), "请选择客户");
		
		AssertUtil.notNull(saleChance.getCgjl(), "销售机会概率不能为空");
		
	}
	public void updateSaleChance(SaleChance saleChance){
		Integer id = saleChance.getId();
		AssertUtil.intIsNotEmpty(id, "请选择记录进行更新");
		paramsCheck(saleChance);
		saleChanceDao.updateSaleChance(checkSaleChance(saleChance));
		
	}
	public SaleChance checkSaleChance(SaleChance saleChance) {
		int state =saleChance.getState();
		SaleChance saleChanceFromDB = saleChanceDao.findById(saleChance.getId());
		String assinManFromDB=saleChanceFromDB.getAssignMan();
		Date assignTime = null;
		String assignMan =saleChance.getAssignMan();
		if(saleChance.getState()==null||saleChance.getState()==0){
			if(StringUtils.isNotBlank(assignMan)){
				state=1;
				assignTime=new Date();
			}
		}
		if(!StringUtils.isNotBlank(assignMan)){
			state=0;
			assignTime=new Date();
		}
		
		if(!assinManFromDB.equals(assignMan)){
			assignTime=new Date();
		}
		saleChance.setAssignMan(assignMan);
		saleChance.setAssignTime(assignTime);
		saleChance.setState(state);
		
		return saleChance;
		
	}
	
	
	

}
