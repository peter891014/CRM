package com.shsxt.crm.exception;

public class ParamException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String message;
	public int code;
	
	public ParamException(){
		
	}
	public ParamException(String msg) {
		super();
		this.message = msg;
		this.code = -1;
	}
	
	public ParamException(int code,String msg) {
		super();
		this.message = msg;
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String msg) {
		this.message = msg;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	

}
