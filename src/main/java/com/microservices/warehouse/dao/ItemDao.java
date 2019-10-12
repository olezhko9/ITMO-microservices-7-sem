package com.microservices.warehouse.dao;

import com.microservices.warehouse.model.Item;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ItemDao {

    int addItem(UUID id, Item item);

    default int addItem(Item item) {
        UUID id = UUID.randomUUID();
        return addItem(id, item);
    }

    List<Item> getAllItems();

    Optional<Item> getItemById(UUID id);

    Item updateItemAmount(UUID id, String amountType, int amount);
}
