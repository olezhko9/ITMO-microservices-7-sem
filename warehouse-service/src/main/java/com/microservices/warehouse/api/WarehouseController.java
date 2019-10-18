package com.microservices.warehouse.api;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.microservices.warehouse.dto.ItemCreationDto;
import com.microservices.warehouse.dto.ItemDto;
import com.microservices.warehouse.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("warehouse")
@RestController
public class WarehouseController {

    private final WarehouseService warehouseService;

    @Autowired
    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @PostMapping(path = "/items")
    public void addItem(@RequestBody ItemCreationDto item) {
        warehouseService.addItem(item);
    }

    @GetMapping(path = "/items")
    public List<ItemDto> getAllItems() {
        return warehouseService.getAllItems();
    }

    @GetMapping(path = "/items/{id}")
    public ItemDto getItemById(@PathVariable("id") UUID id) {
        return warehouseService.getItemById(id);
    }

    @PutMapping(path = "/items/{id}/amount")
    public ItemDto updateItemAmount(@PathVariable("id") UUID id, @RequestBody ObjectNode json) {
        String amountType = json.get("amountType").asText();
        int amount = json.get("amount").asInt();
        return warehouseService.updateItemAmount(id, amountType, amount);
    }
}
