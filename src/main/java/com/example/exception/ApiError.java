package com.example.exception;

import java.util.Date;

public class ApiError {
	private Date timeStamp;
	private String msg;
	private String errorresponse;
	public ApiError(Date timeStamp, String msg, String errorresponse) {
		super();
		this.timeStamp=timeStamp;
		this.msg=msg;
		this.errorresponse=errorresponse;
	}
	
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getErrorresponse() {
		return errorresponse;
	}
	public void setErrorresponse(String errorresponse) {
		this.errorresponse = errorresponse;
	}
	

}

