package com.deepak.PurchaseManagementSystem.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ItemNotFoundException extends RuntimeException {

    private final int statusCode;
    private final String statusName;

    public ItemNotFoundException(String message) {
        super(message);
        this.statusName = HttpStatus.NOT_FOUND.name();
        this.statusCode = HttpStatus.NOT_FOUND.value();
    }

    public ItemNotFoundException(long id) {
        super("Item with ID " + id + " not found");
        this.statusName = HttpStatus.NOT_FOUND.name();
        this.statusCode = HttpStatus.NOT_FOUND.value();
    }
}