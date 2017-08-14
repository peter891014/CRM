package com.shsxt.crm.vo;

import java.io.Serializable;

public class UserLoginIdentify  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userIdString; // ½«userId¼ÓÃÜ
    private String userName;
    private String realName;
	public String getUserIdString() {
		return userIdString;
	}
	public void setUserIdString(String userIdString) {
		this.userIdString = userIdString;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
}
