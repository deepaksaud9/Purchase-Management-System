package com.deepak.PurchaseManagementSystem.mapper;

import com.deepak.PurchaseManagementSystem.dto.ItemDto;
import com.deepak.PurchaseManagementSystem.model.Item;

public interface ItemMapper {
    public Item toItem(ItemDto itemDto);
    public ItemDto toItemDto(Item item);
}
