package com.bank.enumm;

public enum AddressType {
	
	CURRENT_ADDRESS("Current Address"),
    CURRENT_ADDRESS_OLD("Old Current Address"),
    PERMANENT_ADDRESS("Permanent Address"),
    PERMANENT_ADDRESS_OLD("Old Permanent Address");

    private String displayAddressType;
    
    AddressType(String displayAddressType) {
        this.displayAddressType = displayAddressType;
    }

    public String getDisplayAddressType() {
        return displayAddressType;
    }
}
