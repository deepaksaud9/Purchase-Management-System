package com.deepak.PurchaseManagementSystem.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class ApiResponse<T> {
    private String message;
    private int statusCode;
    private T payload;

    public ApiResponse(int statusCode, T payload){
        this.statusCode = statusCode;
        this.payload = payload;
    }
    public ApiResponse(String message, int statusCode, T payload){
        this.statusCode = statusCode;
        this.payload = payload;
    }
}
