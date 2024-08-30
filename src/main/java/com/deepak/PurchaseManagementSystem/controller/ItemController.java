package com.deepak.PurchaseManagementSystem.controller;

import com.deepak.PurchaseManagementSystem.dto.ItemDto;
import com.deepak.PurchaseManagementSystem.response.ApiResponse;
import com.deepak.PurchaseManagementSystem.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/item")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/save")
    public ResponseEntity<ApiResponse> createItem(@RequestBody ItemDto itemDto){
        ItemDto savedItems = itemService.saveItem(itemDto);
        ApiResponse response = new ApiResponse(HttpStatus.OK.value(), itemDto);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/fetchById/{id}")
    public ResponseEntity<ApiResponse> getItemById(@PathVariable long id){
        ItemDto itemDto = itemService.getItemById(id);
        ApiResponse response = new ApiResponse(HttpStatus.OK.value(),itemDto);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    
}
