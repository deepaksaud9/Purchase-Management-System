package com.deepak.PurchaseManagementSystem.controller;

import com.deepak.PurchaseManagementSystem.dto.ItemDto;
import com.deepak.PurchaseManagementSystem.response.ApiResponse;
import com.deepak.PurchaseManagementSystem.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        ApiResponse response = new ApiResponse(HttpStatus.OK.value(),HttpStatus.OK.name(), savedItems);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateItem(@PathVariable Long id, @RequestBody ItemDto itemDto) {
        itemDto.setId(id);
        ItemDto updatedItem = itemService.saveItem(itemDto);
        ApiResponse response = new ApiResponse(HttpStatus.OK.value(),HttpStatus.OK.name(), updatedItem);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/fetchById/{id}")
    public ResponseEntity<ApiResponse> getItemById(@PathVariable long id){
        ItemDto itemDto = itemService.getItemById(id);
        ApiResponse response = new ApiResponse(HttpStatus.OK.value(),HttpStatus.OK.name(), itemDto);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/fetchAllItem")
    public ResponseEntity<ApiResponse> getAllItems(){
        List<ItemDto> itemDto = itemService.getAllItems();
        ApiResponse response = new ApiResponse(HttpStatus.OK.value(),HttpStatus.OK.name(), itemDto);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteItemById(@PathVariable Long id){
        itemService.deleteItem(id);
        ApiResponse response = new ApiResponse(HttpStatus.OK.value(),HttpStatus.OK.name(), "Deleted successfully");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    
}
