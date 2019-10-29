package com.microservices.warehouse.service;

import com.microservices.warehouse.dao.ItemDao;
import com.microservices.warehouse.dto.ItemAmountDto;
import com.microservices.warehouse.dto.ItemCreationDto;
import com.microservices.warehouse.dto.ItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseService {

    private final ItemDao itemDao;

    @Autowired
    public WarehouseService(@Qualifier("sqlite") ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    public ItemDto addItem(ItemCreationDto item) {
        return itemDao.addItem(item);
    }

    public List<ItemDto> getAllItems() {
        return itemDao.getAllItems();
    }

    public ItemDto getItemById(int id) {
        return itemDao.getItemById(id);
    }

    public ItemDto updateItemAmount(int id, ItemAmountDto itemAmountDto) {
        return itemDao.updateItemAmount(id, itemAmountDto);
    }
}
