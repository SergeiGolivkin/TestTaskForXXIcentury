package com.xxicentury.testTask.converter;


import com.xxicentury.testTask.dto.OrderLineDto;
import com.xxicentury.testTask.entity.OrderLine;
import org.springframework.stereotype.Component;

@Component
public class OrderLineConverter {

    public OrderLineDto fromOrderLineToOrderLineDto(OrderLine orderLine){
        return OrderLineDto.builder()
                .id(orderLine.getId())
                .order(orderLine.getOrder())
                .goods(orderLine.getGoods())
                .count(orderLine.getCount())
                .build();
    }

    public OrderLine fromOrderLineDtoToOrderLine(OrderLineDto orderLineDto){
        OrderLine orderLine = new OrderLine();
        orderLine.setId(orderLineDto.getId());
        orderLine.setOrder(orderLineDto.getOrder());
        orderLine.setGoods(orderLineDto.getGoods());
        orderLine.setCount(orderLineDto.getCount());
        return orderLine;
    }
}
