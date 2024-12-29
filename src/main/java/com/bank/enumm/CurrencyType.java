package com.bank.enumm;

public enum CurrencyType {

	USD("USD"),
	INR("INR"),
	EUR("EUR"),
	GBP("GBP");
	
	private String displayValue;

	public String getDisplayValue() {
		return displayValue;
	}

	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}

	private CurrencyType(String displayValue) {
		this.displayValue = displayValue;
	}
	
	
}
