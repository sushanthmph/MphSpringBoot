package com.test.exceptions;

import java.util.Date;

public class ErrorMessage {
	private Date timestamp;
	private String url;
	private String message;
	private int statusCode;
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	@Override
	public String toString() {
		return "ErrorMessage [timestamp=" + timestamp + ", url=" + url + ", message=" + message + ", statusCode="
				+ statusCode + "]";
	}
	
	
}
