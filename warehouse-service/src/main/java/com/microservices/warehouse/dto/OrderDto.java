package com.microservices.warehouse.dto;

import com.microservices.warehouse.model.Order;

import java.util.ArrayList;

public class OrderDto extends Order {

    public ArrayList<OrderItemDto> getItems() {
        return items;
    }

    private final ArrayList<OrderItemDto> items;

    public OrderDto(Order order, ArrayList<OrderItemDto> items){
        super(order.getId(), order.getTotalAmount(), order.getOrderStatus().ordinal(), String.valueOf(order.totalCost));
        this.items = items;
    }
}
