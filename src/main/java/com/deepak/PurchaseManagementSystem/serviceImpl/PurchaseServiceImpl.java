package com.deepak.PurchaseManagementSystem.serviceImpl;

import com.deepak.PurchaseManagementSystem.exception.ItemCreationException;
import com.deepak.PurchaseManagementSystem.model.Item;
import com.deepak.PurchaseManagementSystem.model.PacketNumber;
import com.deepak.PurchaseManagementSystem.model.Purchase;
import com.deepak.PurchaseManagementSystem.repository.PurchaseRepository;
import com.deepak.PurchaseManagementSystem.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Override
    public void save(Purchase purchase) {
        itemValidation(purchase);

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


    private Object generatePacketNumbers(Item item) {
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
}
