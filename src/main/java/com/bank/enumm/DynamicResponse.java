package com.bank.enumm;

import java.util.HashMap;
import java.util.Map;

public class DynamicResponse<Object> {
	
	private String status;
	private Map<String , Object>data= new HashMap();

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public DynamicResponse() {
		super();
	
	}

	public void  add(String key , Object value) {
		this.data.put(key, value);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
