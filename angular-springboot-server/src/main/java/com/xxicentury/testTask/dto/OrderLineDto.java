package com.xxicentury.testTask.dto;

import com.xxicentury.testTask.entity.Goods;
import com.xxicentury.testTask.entity.Order;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderLineDto {

    private Long id;
    private Order order;
    private Goods goods;
    private Integer count;

}
