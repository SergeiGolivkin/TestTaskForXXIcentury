package com.xxicentury.testTask.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GoodsDto {

    private Long id;
    private String name;
    private double price;
}
