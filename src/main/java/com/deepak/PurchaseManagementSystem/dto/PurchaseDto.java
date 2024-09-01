package com.deepak.PurchaseManagementSystem.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class PurchaseDto {
    private LocalDate purchaseDate;
    private List<Long> itemIds;
    private String status;

}
