package com.xxicentury.testTask.converter;

import com.xxicentury.testTask.dto.GoodsDto;
import com.xxicentury.testTask.entity.Goods;
import org.springframework.stereotype.Component;

@Component
public class GoodsConverter {

    public GoodsDto fromGoodsToGoodsDto(Goods goods){
        return GoodsDto.builder()
                .id(goods.getId())
                .name(goods.getName())
                .price(goods.getPrice())
                .build();
    }

    public Goods fromGoodsDtoToGoods(GoodsDto goodsDto){
        Goods goods = new Goods();
        goods.setId(goodsDto.getId());
        goods.setName(goodsDto.getName());
        goods.setPrice(goodsDto.getPrice());
        return goods;
    }

}
