package com.bank.enumm;

public enum TransactionType {
	
	DEPOSIT("Deposit"),
	WITHDRAWAL("Withdrawal"),
	TRANSFER("Transfer"),
	REFUND("Refund");
	
	private String displayName;

	private TransactionType(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	

}
