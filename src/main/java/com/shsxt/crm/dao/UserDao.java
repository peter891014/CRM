package com.shsxt.crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.shsxt.crm.model.User;

public interface UserDao {
	@Select("select id,user_name,password,true_name from t_user where" + "  id=#{userId}")
	User findById(Integer id);

	@Select("select id, user_name, password, true_name, email " + " from t_user where user_name = #{userName}")
	User findByUserName(@Param(value = "userName") String userName);
    
	
	@Select("select id,  true_name from t_user ")
	List<User> find_customer_manager();

}
