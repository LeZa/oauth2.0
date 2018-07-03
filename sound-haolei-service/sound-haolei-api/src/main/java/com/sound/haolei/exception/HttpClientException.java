package com.sound.haolei.exception;

/**
 * httpClient请求异常
 *
 */
public class HttpClientException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer errcode;
	
	public Integer getErrcode(){
		return this.errcode;
	}

	public HttpClientException() {
	}

	public HttpClientException(int errCode, String msg) {
		super(msg);
		this.errcode = errCode;
	}
	
	public HttpClientException(int errCode) {
		super();
		this.errcode = errCode;
	}

	@Override
	public String getMessage() {
		String msg = "httpclient invoke err : " + this.errcode + ";" + super.getMessage();
		return msg;
	}

}
