package com.deepak.PurchaseManagementSystem.service;

import com.deepak.PurchaseManagementSystem.dto.ItemDto;

public interface ItemService {
    public ItemDto saveItem(ItemDto itemRequest);
    ItemDto getItemById(Long id);
}
