package com.xxicentury.testTask.dto;


import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class OrderDto {

    private Long id;
    private  String client;
    private Date date;
    private String address;
}
