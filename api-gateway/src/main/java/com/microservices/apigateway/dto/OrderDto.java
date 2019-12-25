package com.microservices.apigateway.dto;

import java.util.ArrayList;


public class OrderDto {

    private Integer id;
    private Integer totalAmount;
    private OrderStatus orderStatus;
    public String totalCost;
    private ArrayList<OrderItemDto> items;

    public OrderDto() {}

    public Integer getId() {
        return id;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public double getTotalCost() {
        return Double.parseDouble(totalCost);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setItems(ArrayList<OrderItemDto> items) {
        this.items = items;
    }

    public ArrayList<OrderItemDto> getItems() {
        return items;
    }

    public OrderDto(Integer id,
                 Integer totalAmount,
                 Integer orderStatus,
                 String totalCost,
                 ArrayList<OrderItemDto> items) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.totalCost = totalCost;
        this.orderStatus = OrderStatus.values()[orderStatus];
    }

//    public Order(@JsonProperty("totalAmount") Integer totalAmount,
//                 @JsonProperty("totalCost") String totalCost) {
//        this.id = null;
//        this.totalAmount = totalAmount;
//        this.totalCost = totalCost;
//        this.orderStatus = OrderStatus.COLLECTING;
//    }


//    public OrderDto(Order order, ArrayList<OrderItemDto> items){
//        super(order.getId(), order.getTotalAmount(), order.getOrderStatus().ordinal(), String.valueOf(order.totalCost));
////        System.out.println(order);
//        this.items = items;
//    }
}
