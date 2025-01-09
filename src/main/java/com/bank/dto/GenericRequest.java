package com.bank.dto;

public class GenericRequest<Object> {
	private Object data;
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	

}
