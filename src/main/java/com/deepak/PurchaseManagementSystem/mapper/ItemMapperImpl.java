package com.deepak.PurchaseManagementSystem.mapper;

import com.deepak.PurchaseManagementSystem.dto.ItemDto;
import com.deepak.PurchaseManagementSystem.model.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemMapperImpl implements ItemMapper{
    public Item toItem(ItemDto itemDto){
        Item item = new Item();
        item.setId(itemDto.getId());
        item.setName(itemDto.getName());
        item.setItemCode(itemDto.getItemCode());
        item.setQuantity(itemDto.getQuantity());
        item.setPackingType(itemDto.getPackingType());
        item.setPackQuantity(itemDto.getPackQuantity());
        return item;
    }

    public ItemDto toItemDto(Item item){

        ItemDto itemDto = new ItemDto();
        itemDto.setId(item.getId());
        itemDto.setName(item.getName());
        itemDto.setItemCode(item.getItemCode());
        itemDto.setQuantity(item.getQuantity());
        itemDto.setPackingType(item.getPackingType());
        itemDto.setPackQuantity(item.getPackQuantity());
        return itemDto;
    }

}
