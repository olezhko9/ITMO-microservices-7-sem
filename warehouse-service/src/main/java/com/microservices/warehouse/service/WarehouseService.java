package com.microservices.warehouse.service;

import com.microservices.warehouse.dao.ItemDao;
import com.microservices.warehouse.dto.ItemCreationDto;
import com.microservices.warehouse.dto.ItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WarehouseService {

    private final ItemDao itemDao;

    @Autowired
    public WarehouseService(@Qualifier("sqlDao") ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    public ItemDto addItem(ItemCreationDto item) {
        return itemDao.addItem(item);
    }

    public List<ItemDto> getAllItems() {
        return itemDao.getAllItems();
    }

    public ItemDto getItemById(UUID id) {
        return itemDao.getItemById(id);
    }

    public ItemDto updateItemAmount(UUID id, String amountType, int amount) {
        return itemDao.updateItemAmount(id, amountType, amount);
    }
}
