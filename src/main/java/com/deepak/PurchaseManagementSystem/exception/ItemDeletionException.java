package com.deepak.PurchaseManagementSystem.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ItemDeletionException extends RuntimeException {
    private final int statusCode;
    private final String statusName;

    public ItemDeletionException(Long id) {
        super("Failed to delete item with ID " + id);
        this.statusName = HttpStatus.NOT_FOUND.name();
        this.statusCode = HttpStatus.NOT_FOUND.value();
    }
}