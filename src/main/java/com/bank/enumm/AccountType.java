package com.bank.enumm;

public enum AccountType {
	
	SAVING_ACCOUNT("Saving Account"),
	CURRENT_ACCOUT("Current Account"),
	FIXED_ACCOUNT("Fixed Account");
	
	private String displayValue;

	public String getDisplayValue() {
		return displayValue;
	}

	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}

	private AccountType(String displayValue) {
		this.displayValue = displayValue;
	}
	
	

}
