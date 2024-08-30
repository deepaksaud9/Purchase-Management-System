package com.deepak.PurchaseManagementSystem.serviceImpl;

import com.deepak.PurchaseManagementSystem.dto.ItemDto;
import com.deepak.PurchaseManagementSystem.mapper.ItemMapper;
import com.deepak.PurchaseManagementSystem.model.Item;
import com.deepak.PurchaseManagementSystem.repository.ItemRepository;
import com.deepak.PurchaseManagementSystem.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ItemServiceImpl implements ItemService {


    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    private static final String PREFIX = "Item-";
    private static final int PADDING_LENGTH = 3;
    public ItemServiceImpl(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    @Override
    public ItemDto saveItem(ItemDto itemDto) {

        Item item = itemMapper.toItem(itemDto);
//        item.setItemCode("item-"+UUID.randomUUID());
        String itemCode = generateItemCode();
        item.setItemCode(itemCode);

        Item itemSaved = itemRepository.save(item);
         return  itemMapper.toItemDto(itemSaved);

    }

    private String generateItemCode() {
        Long maxId = itemRepository.findMaxId();
        if (maxId == null) {
            maxId = 0L;
        }
        return String.format("%s%0" + PADDING_LENGTH + "d", PREFIX, maxId + 1);
    }
}
