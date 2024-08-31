package com.deepak.PurchaseManagementSystem.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ItemCreationException extends RuntimeException {
    private final int statusCode;
    private final String statusName;
    public ItemCreationException(String message) {
        super("Failed to create item: " + message);
        this.statusName = HttpStatus.NOT_FOUND.name();
        this.statusCode = HttpStatus.NOT_FOUND.value();
    }


}