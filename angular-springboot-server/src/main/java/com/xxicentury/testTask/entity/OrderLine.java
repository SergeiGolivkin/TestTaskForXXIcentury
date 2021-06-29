package com.xxicentury.testTask.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "order_line")
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "order_id")
    @OneToOne()
    private Order order;

    @JoinColumn(name = "goods_id")
    @OneToOne()
    private Goods goods;

    @Column
    private Integer count;
}

