package com.microservices.apigateway.dto;

public class AggregatedOrderItemDro {

    private ItemDto itemDto;
    private OrderItemDto orderItemDto;

    public AggregatedOrderItemDro(ItemDto itemDto, OrderItemDto orderItemDto) {
        this.itemDto = itemDto;
        this.orderItemDto = orderItemDto;
    }

    public ItemDto getItemDto() {
        return itemDto;
    }

    public void setItemDto(ItemDto itemDto) {
        this.itemDto = itemDto;
    }

    public OrderItemDto getOrderItemDto() {
        return orderItemDto;
    }

    public void setOrderItemDto(OrderItemDto orderItemDto) {
        this.orderItemDto = orderItemDto;
    }
}
