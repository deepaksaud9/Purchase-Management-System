package com.deepak.PurchaseManagementSystem.controller;
import com.deepak.PurchaseManagementSystem.model.Purchase;
import com.deepak.PurchaseManagementSystem.response.ApiResponse;
import com.deepak.PurchaseManagementSystem.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/purchase")
public class PurchaseController {
    @Autowired
    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping("/savePurchase")
    public ResponseEntity<ApiResponse<?>> save(@RequestBody Purchase purchase){
        purchaseService.savePurchase(purchase);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(HttpStatus.OK.value(),"Success",purchase));
    }

}
