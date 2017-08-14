package com.shsxt.crm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shsxt.crm.dao.UserDao;
import com.shsxt.crm.exception.ParamException;
import com.shsxt.crm.model.User;
import com.shsxt.crm.util.MD5Util;
import com.shsxt.crm.util.UserIDBase64;
import com.shsxt.crm.vo.UserLoginIdentify;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public UserLoginIdentify find(String userName, String passWord) {
		Map<String, Object> result = new HashMap<String, Object>();
		if (StringUtils.isBlank(userName)) {
			/*result.put("msg", "用户名非空");
			result.put("code", "-1");
			return result;*/
			throw new ParamException("用户名非空");
		}
		if (StringUtils.isBlank(passWord)) {
			/*result.put("msg", "密码非空");
			result.put("code", "-1");
			return result;*/
			throw new ParamException("密码非空");
		}

		User user = userDao.findByUserName(userName);
		if (user == null) {
			/*result.put("msg", "用户名或密码错误");
			result.put("code", "-1");
			return result;*/
			throw new ParamException("用户名或密码错误");
		}

		if (!user.getPassword().equals(MD5Util.md5Method(passWord))) {
			/*result.put("msg", "用户名或密码错误");
			result.put("code", "-1");
			return result;*/
			throw new ParamException("用户名或密码错误");
		}
		UserLoginIdentify userLoginIdentify = new UserLoginIdentify();
		userLoginIdentify.setRealName(user.getTrueName());
		userLoginIdentify.setUserIdString(UserIDBase64.encoderUserID(user.getId()));
		userLoginIdentify.setUserName(userName);
		/*if (user.getPassword().equals(MD5Util.md5Method(passWord))) {
			result.put("msg", "登录成功");
			result.put("code", "1");
			result.put("result", userLoginIdentify);
			return result;
		}*/
		return userLoginIdentify;

	}

	public List<User> find_customer_manager() {
		return	userDao.find_customer_manager();
		
	}
}
