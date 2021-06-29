package com.xxicentury.testTask.service;

import com.xxicentury.testTask.converter.OrderConverter;
import com.xxicentury.testTask.dto.OrderDto;
import com.xxicentury.testTask.entity.Order;
import com.xxicentury.testTask.exception.OrderNotFoundException;
import com.xxicentury.testTask.exception.ValidationException;
import com.xxicentury.testTask.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderConverter orderConverter;


    public OrderDto findByIdOrder(Long id) throws OrderNotFoundException {
        Order order = orderRepository.findById(id).get();
        if (order == null) {
            throw new OrderNotFoundException("Order not found - " + id );
        }
        return orderConverter.fromOrderToOrderDto(order);
    }

    public List<OrderDto> findAllOrders(){
        return orderRepository.findAll()
                .stream()
                .map(orderConverter::fromOrderToOrderDto)
                .collect(Collectors.toList());
    }

    public void saveOrder(OrderDto orderDto) throws ValidationException {
        validateOrderDto(orderDto);
        Order savedOrder = orderRepository.save(orderConverter.fromOrderDtoToOrder(orderDto));
        orderConverter.fromOrderToOrderDto(savedOrder);
    }

    public void updateOrder(Long id, Order order) throws OrderNotFoundException {
        Order newOrder = orderRepository.findById(id).get();
        if (newOrder == null) {
            throw new OrderNotFoundException("Order not found - " + id );
        }

        newOrder.setId(order.getId());
        newOrder.setClient(order.getClient());
        newOrder.setDate(order.getDate());
        newOrder.setAddress(order.getAddress());
        orderRepository.save(newOrder);
    }

    public void deleteByIdOrder(Long id) throws OrderNotFoundException {
        if (orderRepository.findById(id).get() == null) {
            throw new OrderNotFoundException("Goods not found - " + id);
        }
        orderRepository.deleteById(id);
    }

    private void validateOrderDto(OrderDto orderDto) throws ValidationException {
        if (isNull(orderDto)) {
            throw new ValidationException("Object order is null");
        }
    }
}
