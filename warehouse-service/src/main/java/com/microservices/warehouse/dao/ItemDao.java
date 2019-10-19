package com.microservices.warehouse.dao;

import com.microservices.warehouse.dto.ItemCreationDto;
import com.microservices.warehouse.dto.ItemDto;

import java.util.List;

public interface ItemDao {

    ItemDto addItem(ItemCreationDto item);

    List<ItemDto> getAllItems();

    ItemDto getItemById(int id);

    ItemDto updateItemAmount(int id, String amountType, int amount);
}
