package com.microservices.warehouse.dao;

import com.microservices.warehouse.dto.ItemCreationDto;
import com.microservices.warehouse.dto.ItemDto;
import com.microservices.warehouse.model.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository("sqlDao")
public class WarehouseDataService implements ItemDao {

    private static List<Item> DB = new ArrayList<>();

    @Override
    public ItemDto addItem(UUID id, ItemCreationDto itemCreationDto) {
        Item createdItem = itemCreationDto.toItem();
        createdItem.setId(id);
        DB.add(createdItem);
        return ItemDto.fromItem(createdItem);
    }

    @Override
    public List<ItemDto> getAllItems() {
        return DB.stream()
                .map(ItemDto::fromItem)
                .collect(Collectors.toList());
    }

    @Override
    public ItemDto getItemById(UUID id) {
        Optional<Item> item = DB.stream()
                .filter(_item -> _item.getId().equals(id))
                .findFirst();
        return item.map(ItemDto::fromItem).orElse(null);
    }

    @Override
    public ItemDto updateItemAmount(UUID id, String amountType, int amountDiff) {
        Optional<Item> item = DB.stream()
                .filter(_item -> _item.getId().equals(id))
                .findFirst();

        if (item.isPresent()) {
            int itemIdx = DB.indexOf(item.get());
            Item itemToUpdate = item.get();
            System.out.println(itemIdx);

            if (amountType.equals("actual")) {
                itemToUpdate.setActualAmount(itemToUpdate.getActualAmount() + amountDiff);
            }
            else if (amountType.equals("available")) {
                itemToUpdate.setAvailableAmount(itemToUpdate.getAvailableAmount() + amountDiff);
            }
            DB.set(itemIdx, itemToUpdate);
            return ItemDto.fromItem(itemToUpdate);
        } else {
            return null;
        }
    }
}
