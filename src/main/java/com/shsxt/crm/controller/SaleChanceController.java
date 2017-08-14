package com.shsxt.crm.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shsxt.crm.dto.SaleChanceQuery;
import com.shsxt.crm.model.ResultInfo;
import com.shsxt.crm.model.SaleChance;
import com.shsxt.crm.service.SaleChanceService;

@Controller
@RequestMapping("sale_chance")
public class SaleChanceController  extends BaseController{
            
	    @Autowired
		private SaleChanceService saleChanceService;
	    
	    @RequestMapping("index")
	    public String index() {
	    	/*String ctx=req.getContextPath();
	    	model.addAttribute(ctx);*/
			return "sale_chance";
		}
	    
	     @RequestMapping("list")
	    @ResponseBody
	    public Map<String,Object> findSaleChance(SaleChanceQuery saleChanceQuery){
	    	
	   Map<String,Object> map=	saleChanceService.find(saleChanceQuery);
	   
			return map;
	    	
	    }
	     
	     @RequestMapping("add")
		  @ResponseBody
	     public ResultInfo insertSaleChance(SaleChance saleChance){
	    	
	    	 saleChanceService.insertSaleChance(saleChance);
	    	 return  success("添加成功");
	     }
	     
	     @RequestMapping("update")
		  @ResponseBody
	     public ResultInfo update(SaleChance saleChance){
	    	
	    	 saleChanceService.updateSaleChance(saleChance);
	    	 return  success("修改成功");
	     }
}
