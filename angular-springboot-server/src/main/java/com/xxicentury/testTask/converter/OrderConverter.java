package com.xxicentury.testTask.converter;


import com.xxicentury.testTask.dto.OrderDto;
import com.xxicentury.testTask.entity.Order;
import org.springframework.stereotype.Component;


@Component
public class OrderConverter {

    public OrderDto fromOrderToOrderDto(Order order){
        return OrderDto.builder()
                .id(order.getId())
                .client(order.getClient())
                .date(order.getDate())
                .address(order.getAddress())
                .build();
    }

    public Order fromOrderDtoToOrder(OrderDto orderDto){
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setClient(orderDto.getClient());
        order.setDate(orderDto.getDate());
        order.setAddress(orderDto.getAddress());
        return order;
    }
}
