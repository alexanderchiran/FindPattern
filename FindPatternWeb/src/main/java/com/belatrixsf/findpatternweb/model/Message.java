package com.belatrixsf.findpatternweb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author Alexander Chiran paulo.alexander12@gmail.com
 * 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {

	
	String code;
	
	String message;
	
	



	public String getCode() {
		return code;
	}





	public void setCode(String code) {
		this.code = code;
	}





	public String getMessage() {
		return message;
	}





	public void setMessage(String message) {
		this.message = message;
	}





	@Override
	public String toString() {
		return "Message [code=" + code + ", message=" + message + "]";
	}
}
