package com.sound.haolei.exception;

public class BusinessException extends Exception {

	private static final long serialVersionUID = 1L;

	private int code;

	private String msg;

	public BusinessException() {
	}

	public BusinessException(String message,int code) {
		super(message);
		this.code=code;
		this.msg=message;
	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}


}
