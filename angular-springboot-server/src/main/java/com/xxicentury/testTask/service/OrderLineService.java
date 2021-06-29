package com.xxicentury.testTask.service;


import com.xxicentury.testTask.converter.OrderLineConverter;
import com.xxicentury.testTask.dto.OrderLineDto;
import com.xxicentury.testTask.entity.OrderLine;
import com.xxicentury.testTask.exception.OrderLineNotFoundException;
import com.xxicentury.testTask.exception.ValidationException;
import com.xxicentury.testTask.repository.OrderLineRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class OrderLineService {

    final private OrderLineRepository orderLineRepository;
    private final OrderLineConverter orderLineConverter;


    public OrderLineDto findByIdOrderLine(Long id) throws OrderLineNotFoundException {
        OrderLine orderLine = orderLineRepository.findById(id).get();
        if (orderLine == null) {
            throw new OrderLineNotFoundException("OrderLine not found - " + id );
        }
        return orderLineConverter.fromOrderLineToOrderLineDto(orderLine);
    }

    public List<OrderLineDto> findAllOrderLine(){
        return orderLineRepository.findAll()
                .stream()
                .map(orderLineConverter::fromOrderLineToOrderLineDto)
                .collect(Collectors.toList());
    }

    public void saveOrderLine(OrderLineDto orderLineDto) throws ValidationException {
        validateOrderLineDto(orderLineDto);
        OrderLine savedOrderLine = orderLineRepository.save(orderLineConverter.fromOrderLineDtoToOrderLine(orderLineDto));
        orderLineConverter.fromOrderLineToOrderLineDto(savedOrderLine);
    }

    public void updateOrderLine(Long id, OrderLine orderLine) throws OrderLineNotFoundException {
        OrderLine newOrderLine = orderLineRepository.findById(id).get();
        if (newOrderLine == null) {
            throw new OrderLineNotFoundException("OrderLine not found - " + id );
        }

        newOrderLine.setId(orderLine.getId());
        newOrderLine.setOrder(orderLine.getOrder());
        newOrderLine.setGoods(orderLine.getGoods());
        newOrderLine.setCount(orderLine.getCount());
        orderLineRepository.save(newOrderLine);
    }

    public void deleteByIdOrderLine(Long id) throws OrderLineNotFoundException {
        if (orderLineRepository.findById(id).get() == null) {
            throw new OrderLineNotFoundException("OrderLine not found - " + id);
        }
        orderLineRepository.deleteById(id);
    }

    private void validateOrderLineDto(OrderLineDto orderLineDto) throws ValidationException {
        if (isNull(orderLineDto)) {
            throw new ValidationException("Object orderLine is null");
        }
    }
}
