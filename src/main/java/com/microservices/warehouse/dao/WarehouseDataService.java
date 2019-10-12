package com.microservices.warehouse.dao;

import com.microservices.warehouse.model.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("sqlDao")
public class WarehouseDataService implements ItemDao {

    private static List<Item> DB = new ArrayList<>();

    @Override
    public int addItem(UUID id, Item item) {
        DB.add(new Item(id, item.getName(), item.getPrice(), item.getActualAmount(), item.getAvailableAmount()));
        return 1;
    }

    @Override
    public List<Item> getAllItems() {
        return DB;
    }

    @Override
    public Optional<Item> getItemById(UUID id) {
        return DB.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
    }

    @Override
    public Item updateItemAmount(UUID id, String amountType, int amountDiff) {
        return getItemById(id)
                .map(item -> {
                    int itemIdx = DB.indexOf(item);
                    if (itemIdx >= 0) {
                        Item itemToUpdate = DB.get(itemIdx);
                        if (amountType.equals("actual")) {
                            Item updatedItem = new Item(
                                    id,
                                    itemToUpdate.getName(),
                                    itemToUpdate.getPrice(),
                                    itemToUpdate.getActualAmount() + amountDiff,
                                    itemToUpdate.getAvailableAmount()
                            );
                            DB.set(itemIdx, updatedItem);
                            return updatedItem;
                        } else if (amountType.equals("available")) {
                            Item updatedItem = new Item(
                                    id,
                                    itemToUpdate.getName(),
                                    itemToUpdate.getPrice(),
                                    itemToUpdate.getActualAmount(),
                                    itemToUpdate.getAvailableAmount() + amountDiff
                            );
                            DB.set(itemIdx, updatedItem);
                            return updatedItem;
                        }
                    }
                    return null;
                })
                .orElse(null);
    }

}
