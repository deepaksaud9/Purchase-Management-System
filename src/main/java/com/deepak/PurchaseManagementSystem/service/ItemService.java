package com.deepak.PurchaseManagementSystem.service;

import com.deepak.PurchaseManagementSystem.dto.ItemDto;

import java.util.List;

public interface ItemService {
    public ItemDto saveItem(ItemDto itemRequest);
    ItemDto getItemById(Long id);
    List<ItemDto> getAllItems();
    String deleteItem(Long id);
}
