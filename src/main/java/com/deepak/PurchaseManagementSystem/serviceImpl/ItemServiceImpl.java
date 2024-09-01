package com.deepak.PurchaseManagementSystem.serviceImpl;

import com.deepak.PurchaseManagementSystem.dto.ItemDto;
import com.deepak.PurchaseManagementSystem.exception.ItemCreationException;
import com.deepak.PurchaseManagementSystem.exception.ItemDeletionException;
import com.deepak.PurchaseManagementSystem.exception.ItemNotFoundException;
import com.deepak.PurchaseManagementSystem.mapper.ItemMapper;
import com.deepak.PurchaseManagementSystem.mapper.ItemMapperImpl;
import com.deepak.PurchaseManagementSystem.model.Item;
import com.deepak.PurchaseManagementSystem.repository.ItemRepository;
import com.deepak.PurchaseManagementSystem.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private static final Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    private static final String PREFIX = "Item-";
    private static final int PADDING_LENGTH = 3;
    public ItemServiceImpl(ItemRepository itemRepository, ItemMapperImpl itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    @Override
    public ItemDto saveItem(ItemDto itemDto) {
       try {
           Item item = new Item();
           if (itemDto.getId() != null) {
               item = itemRepository.findById(itemDto.getId()).orElseThrow(() -> new ItemNotFoundException("this Item with Id"+ itemDto.getId()+" not present in db "));

               // Update items
               item.setName(itemDto.getName());
               item.setQuantity(itemDto.getQuantity());
               item.setItemCode(itemDto.getItemCode());
               item.setPackingType(itemDto.getPackingType());
               item.setPackQuantity(itemDto.getPackQuantity());
           } else {
               //create Item
               item = itemMapper.toItem(itemDto);
               String itemCode = generateItemCode();
               item.setItemCode(itemCode);
           }
           Item item1 = itemRepository.save(item);
           System.out.println(item1.getId()+item1.getItemCode());
           logger.info("Saved Item: ID = {}, ItemCode = {}", item1.getId(), item1.getItemCode());
           ItemDto itemDto1 = itemMapper.toItemDto(item1);
           return itemDto1;

       }catch (Exception e){
            throw new ItemCreationException(e.getMessage());
       }
    }

    @Override
    public ItemDto getItemById(Long id) {

        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item with ID " + id + " not found"));

        return itemMapper.toItemDto(item);
    }

    @Override
    public List<ItemDto> getAllItems() {
        List<Item> items  = itemRepository.findAll();
        ItemDto itemDto = new ItemDto();
        List<ItemDto> itemDtos = items.stream()
                .map(itemMapper::toItemDto)
                .collect(Collectors.toList());
        return itemDtos;
    }

    @Override
    public String deleteItem(Long id) {
        try{
            if (!itemRepository.existsById(id)){
                throw new ItemDeletionException(id);
            }else {
                itemRepository.deleteById(id);
                return "delete successfully";
            }
        }catch (Exception e){
            throw new ItemDeletionException(id);
        }
    }

    private String generateItemCode() {
        Long maxId = itemRepository.findMaxId();
        if (maxId == null) {
            maxId = 0L;
        }
        return String.format("%s%0" + PADDING_LENGTH + "d", PREFIX, maxId + 1);
    }
}
