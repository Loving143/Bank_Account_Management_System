package com.bank.dto;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAnySetter;

@Component
public class GenericFilterRequest {
	
	    //private Map<String, Object> filters; // Object to handle any data type
	private Map<String, Object> filters = new HashMap<>();
	
	private AddRequest request;

	    @JsonAnySetter
	    public void addFilter(String key, Object value) {
	        filters.put(key, value);
	    }
	    
	    public Map<String, Object> getFilters() {
	        return filters;
	    }

	    public void setFilters(Map<String, Object> filters) {
	        this.filters = filters;
	    }

	    @Override
	    public String toString() {
	        return "GenericFilterRequest";
	    }

		public AddRequest getRequest() {
			return request;
		}

		public void setRequest(AddRequest request) {
			this.request = request;
		}


}