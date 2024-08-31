package com.deepak.PurchaseManagementSystem.serviceImpl;

import com.deepak.PurchaseManagementSystem.exception.ItemCreationException;
import com.deepak.PurchaseManagementSystem.model.Item;
import com.deepak.PurchaseManagementSystem.model.PacketNumber;
import com.deepak.PurchaseManagementSystem.model.PacketSerialNumber;
import com.deepak.PurchaseManagementSystem.model.Purchase;
import com.deepak.PurchaseManagementSystem.repository.PurchaseRepository;
import com.deepak.PurchaseManagementSystem.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Override
    public void save(Purchase purchase) {
        itemValidation(purchase);
        purchase.setPurchaseDate(purchase.getPurchaseDate());
        purchase.setCreatedDate(LocalDateTime.now());
        List<Item> items=new ArrayList<>();
        for (Item item: purchase.getItems()){
            List<PacketNumber> packetNumbers= generatePacketNumbers(item);
            List<PacketSerialNumber> packetSerialNumberList= generateSerialNumbers(item);
            item.setPacketNumberList(packetNumbers);
            item.setPacketSerialNumberList(packetSerialNumberList);
            items.add(item);
        }
        purchase.setItems(items);
        purchaseRepository.save(purchase);

    }

    private  void itemValidation(Purchase purchase) {
        if (purchase.getItems().isEmpty()){
            throw new ItemCreationException("Item can not be empty.");
        }
        for (Item item: purchase.getItems()){
            if (item.getQuantity()==0){
                throw new ItemCreationException("Item quantity can not be zero.");
            }
            if (item.getPackingType()==null||item.getPackingType().equals("")){
                throw new ItemCreationException("Package type can not be empty");
            }
            if (item.getPackQuantity()==0){
                throw new ItemCreationException("Package quantity can not be zero.");
            }
        }
    }


    private List<PacketNumber> generatePacketNumbers(Item item) {
        List<PacketNumber> packetNumberList=new ArrayList<>();
        for (int i = 1; i <= item.getQuantity(); i++) {
            PacketNumber packetNumber = new PacketNumber();
            if (i<10) {
                packetNumber.setPacketNumber("PACK-" + item.getItemCode() + "-0" + i);
            }else {
                packetNumber.setPacketNumber("PACK-" + item.getItemCode() + "-" + i);
            }
            packetNumberList.add(packetNumber);
        }
        return packetNumberList;
    }

    private List<PacketSerialNumber> generateSerialNumbers(Item item) {
        List<PacketSerialNumber> packetSerialNumberList=new ArrayList<>();
        double totalSerialNumbers = item.getQuantity() * item.getPackQuantity();
        for (int i = 1; i <= totalSerialNumbers; i++) {
            PacketSerialNumber serialNumber = new PacketSerialNumber();
            serialNumber.setSerialNumber("SER-" + item.getItemCode() + "-" + UUID.randomUUID());
            serialNumber.setItem(item);
            packetSerialNumberList.add(serialNumber);
        }
        return packetSerialNumberList;
    }
}
