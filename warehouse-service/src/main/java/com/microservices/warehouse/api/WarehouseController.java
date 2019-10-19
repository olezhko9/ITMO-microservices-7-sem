package com.microservices.warehouse.api;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.microservices.warehouse.dto.ItemCreationDto;
import com.microservices.warehouse.dto.ItemDto;
import com.microservices.warehouse.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ItemDto> addItem(@RequestBody ItemCreationDto item) {
        return ResponseEntity.ok(warehouseService.addItem(item));
    }

    @GetMapping(path = "/items")
    public ResponseEntity<List<ItemDto>> getAllItems() {
        return ResponseEntity.ok(warehouseService.getAllItems());
    }

    @GetMapping(path = "/items/{id}")
    public ResponseEntity<ItemDto> getItemById(@PathVariable("id") UUID id) {
        ItemDto itemDto = warehouseService.getItemById(id);
        if (itemDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(itemDto);
    }

    @PutMapping(path = "/items/{id}/amount")
    public ResponseEntity<ItemDto> updateItemAmount(@PathVariable("id") UUID id, @RequestBody ObjectNode json) {
        String amountType = json.get("amountType").asText();
        int amount = json.get("amount").asInt();
        ItemDto itemDto = warehouseService.updateItemAmount(id, amountType, amount);
        if (itemDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(itemDto);
    }
}
