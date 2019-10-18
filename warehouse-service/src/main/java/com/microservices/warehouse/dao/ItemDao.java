package com.microservices.warehouse.dao;

import com.microservices.warehouse.dto.ItemCreationDto;
import com.microservices.warehouse.dto.ItemDto;

import java.util.List;
import java.util.UUID;

public interface ItemDao {

    ItemDto addItem(UUID id, ItemCreationDto item);

    default ItemDto addItem(ItemCreationDto item) {
        UUID id = UUID.randomUUID();
        return addItem(id, item);
    }

    List<ItemDto> getAllItems();

    ItemDto getItemById(UUID id);

    ItemDto updateItemAmount(UUID id, String amountType, int amount);
}
