package com.shsxt.crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.shsxt.crm.dto.SaleChanceQuery;
import com.shsxt.crm.model.SaleChance;

public interface SaleChanceDao {

	@SelectProvider(type = SaleChanceProvider.class, method="selectForPage")
	List<SaleChance> findForPage(SaleChanceQuery query ,PageBounds pageBounds);
    
	
	@Insert("INSERT into t_sale_chance (chance_source,customer_id,customer_name,cgjl,overview,link_man,link_phone,description,"
			+ "create_man,assign_man,assign_time,state,dev_result,is_valid)  "
			+ " VALUES( "
			+ " #{chanceSource},#{customerId},#{customerName},#{cgjl},#{overview},#{linkMan},#{linkPhone},"
			+ " #{description},#{createMan},#{assignMan},#{assignTime},#{state}, #{devResult},"
			+ " #{isValid}  ) ")
	int insertSaleChance(SaleChance saleChance);

    @Select("select chance_source,customer_id,customer_name,cgjl,overview,link_man,link_phone,description,"
			+ "create_man,assign_man,assign_time,state,dev_result,is_valid "
			+ " from t_sale_chance where id= #{ id }")
	SaleChance findById( @Param("id") Integer id);

     
    @Update("update t_sale_chance set chance_source = #{chanceSource}, customer_id = #{customerId}, "
			+ "customer_name = #{customerName}, cgjl = #{cgjl}, overview = #{overview},"
			+ "link_man = #{linkMan}, link_phone = #{linkPhone}, description = #{description}, "
			+ "create_man = #{createMan}, assign_man = #{assignMan}, assign_time = #{assignTime},"
			+ " state=#{state},update_date = #{updateDate} where id = #{id}")
	int updateSaleChance(SaleChance saleChance);
	
}
