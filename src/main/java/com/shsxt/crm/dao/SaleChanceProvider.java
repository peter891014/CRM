package com.shsxt.crm.dao;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import com.shsxt.crm.dto.SaleChanceQuery;

public class SaleChanceProvider {
     public final String COLUMS="t.id,t.customer_name, t.overview, t.link_man, t.link_phone, t.create_man, "
					+ " t.create_date, t.assign_man,t.assign_time,t.state";
	public String selectForPage(SaleChanceQuery query){
		String sql= new SQL(){{
			SELECT("t.id,t.customer_name,t.customer_id,t.cgjl ,t.overview, t.link_man, t.link_phone, t.create_man, "
					+ " t.create_date, t.assign_man,t.assign_time,t.state" );
			FROM("t_sale_chance t");
			WHERE("is_valid=1");
			if(!StringUtils.isBlank(query.getCustomerName())){
				AND().WHERE("customer_name like  '%"+ query.getCustomerName() +"%'");
			}
			if (StringUtils.isNotBlank(query.getOverview())) {
				AND().WHERE("overview like '%"+ query.getOverview() +"%'");
			}
			if (StringUtils.isNotBlank(query.getCreateMan())) {
				AND().WHERE("create_man like '%"+ query.getCreateMan() +"%'");
			}
			if (query.getState() != null) {
				AND().WHERE("state = #{state}");
			}
		}}.toString();
		return sql;
	}
	
	
}
