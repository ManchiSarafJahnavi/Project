package com.Project;

public enum OrderStatus {
	PENDING("Pending"),
    PROCESSING("Processing"),
    SHIPPING("Shipping"),
    DELIVERED("Delivered"),
    SHIPPED("Shipped"),
    NEW("New");

    private String displayName;

    private OrderStatus(String displayName) {
        this.displayName = displayName;
    }

    // Getter
    public String getDisplayName() {
        return displayName;
    }

    // Setter
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
	
}
