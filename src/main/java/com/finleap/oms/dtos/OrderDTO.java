package com.finleap.oms.dtos;

public class OrderDTO {
    private String id;
    private String customerId;
    private String description;
    private boolean complete;

    public OrderDTO() {
    }

    public OrderDTO(String id, String customerId, String description, boolean complete) {
        this.id = id;
        this.customerId = customerId;
        this.description = description;
        this.complete = complete;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
