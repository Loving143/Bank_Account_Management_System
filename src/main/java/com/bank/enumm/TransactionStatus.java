package com.bank.enumm;

public enum TransactionStatus {
	
	COMPLETED("Completed"),
	PENDING("Pending"),
	FAILED("Failed"),
	CANCELLED("Cancelled");
	
	private String displayName;

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	private TransactionStatus(String displayName) {
		this.displayName = displayName;
	}

}
