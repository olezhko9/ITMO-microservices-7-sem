package com.microservices.warehouse.api;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.microservices.warehouse.dto.ItemAmountDto;
import com.microservices.warehouse.dto.ItemCreationDto;
import com.microservices.warehouse.dto.ItemDto;
import com.microservices.warehouse.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    public ResponseEntity<ItemDto> getItemById(@PathVariable("id") int id) {
        ItemDto itemDto = warehouseService.getItemById(id);
        if (itemDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(itemDto);
    }

    @PutMapping(path = "/items/{id}/amount")
    public ResponseEntity<ItemDto> updateItemAmount(@PathVariable("id") int id, @RequestBody ItemAmountDto itemAmountDto) {
        ItemDto itemDto = warehouseService.updateItemAmount(id, itemAmountDto);
        if (itemDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(itemDto);
    }
}
