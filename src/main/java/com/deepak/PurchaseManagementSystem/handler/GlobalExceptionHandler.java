package com.deepak.PurchaseManagementSystem.handler;

import com.deepak.PurchaseManagementSystem.exception.ItemCreationException;
import com.deepak.PurchaseManagementSystem.exception.ItemDeletionException;
import com.deepak.PurchaseManagementSystem.exception.ItemNotFoundException;
import com.deepak.PurchaseManagementSystem.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ItemNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ApiResponse> handleItemNotFoundException(ItemNotFoundException ex) {
        ApiResponse response = new ApiResponse(ex.getStatusCode(), ex.getStatusName(),ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ApiResponse> handleRuntimeException(RuntimeException ex) {
        ApiResponse response = new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(ItemDeletionException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ApiResponse> handleItemDeletionException(ItemDeletionException ex){
        ApiResponse response = new ApiResponse(ex.getStatusCode(), ex.getStatusName(),ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(ItemCreationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ApiResponse> handleItemCreationException(ItemCreationException ex){
        ApiResponse response = new ApiResponse(ex.getStatusCode(), ex.getStatusName(),ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}