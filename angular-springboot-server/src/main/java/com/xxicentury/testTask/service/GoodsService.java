package com.xxicentury.testTask.service;

import com.xxicentury.testTask.converter.GoodsConverter;
import com.xxicentury.testTask.dto.GoodsDto;
import com.xxicentury.testTask.entity.Goods;
import com.xxicentury.testTask.exception.AlreadyExistException;
import com.xxicentury.testTask.exception.GoodsNotFoundException;
import com.xxicentury.testTask.exception.ValidationException;
import com.xxicentury.testTask.repository.GoodsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class GoodsService {

    private final GoodsRepository goodsRepository;
    private final GoodsConverter goodsConverter;

    public GoodsDto findByIdGoods(Long id) throws GoodsNotFoundException{
        Goods goods = goodsRepository.findById(id).get();
        if (goods == null) {
            throw new GoodsNotFoundException("Goods not found - " + id );
        }
        return goodsConverter.fromGoodsToGoodsDto(goods);
    }

    public List<GoodsDto> findAllGoods(){
        return goodsRepository.findAll()
                .stream()
                .map(goodsConverter::fromGoodsToGoodsDto)
                .collect(Collectors.toList());
    }

    public void saveGoods(GoodsDto goodsDto) throws AlreadyExistException, ValidationException {
        validateGoodsDto(goodsDto);
        if (goodsRepository.findGoodsByName(goodsDto.getName()) != null) {
           throw  new AlreadyExistException("Goods already exists with the same name!");
        }
        Goods savedGoods = goodsRepository.save(goodsConverter.fromGoodsDtoToGoods(goodsDto));
        goodsConverter.fromGoodsToGoodsDto(savedGoods);
    }

    public void updateGoods(Long id, Goods goods) throws GoodsNotFoundException {
        Goods newGoods  = goodsRepository.findById(id).get();
        if (newGoods == null) {
            throw new GoodsNotFoundException("Goods not found - " + id );
        }
        newGoods.setId(goods.getId());
        newGoods.setName(goods.getName());
        newGoods.setPrice(goods.getPrice());
         goodsRepository.save(newGoods);

    }

    public void deleteGoods(Long id) throws GoodsNotFoundException {
        if (goodsRepository.findById(id).get() == null) {
            throw new GoodsNotFoundException("Goods not found - " + id);
        }
        goodsRepository.deleteById(id);
    }

    private void validateGoodsDto(GoodsDto goodsDto) throws ValidationException {
        if (isNull(goodsDto)) {
            throw new ValidationException("Object goods is null");
        }
    }
}
