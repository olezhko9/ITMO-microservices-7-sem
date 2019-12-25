package com.microservices.apigateway.dto;

import java.util.List;

public class AggregatedOrderDto {

    private OrderDto order;
    private List<AggregatedOrderItemDro> items;

    public OrderDto getOrder() {
        return order;
    }

    public void setOrder(OrderDto order) {
        this.order = order;
    }

    public List<AggregatedOrderItemDro> getItems() {
        return items;
    }

    public void setItems(List<AggregatedOrderItemDro> items) {
        this.items = items;
    }

    public AggregatedOrderDto() {}

    public AggregatedOrderDto(OrderDto order, List<AggregatedOrderItemDro> items) {
        this.order = order;
        this.items = items;
    }
}
