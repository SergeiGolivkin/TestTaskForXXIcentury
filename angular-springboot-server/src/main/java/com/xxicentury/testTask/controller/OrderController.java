package com.xxicentury.testTask.controller;

import com.xxicentury.testTask.dto.OrderDto;
import com.xxicentury.testTask.entity.Order;
import com.xxicentury.testTask.exception.OrderNotFoundException;
import com.xxicentury.testTask.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/order")
@AllArgsConstructor
@Log
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/add")
    public ResponseEntity<?> addOrder(@RequestBody OrderDto orderDto){
        try {
            orderService.saveOrder(orderDto);
            log.info("Handling save order: " + orderDto);
            return ResponseEntity.ok("Order successfully saved");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error has occurred!!!");
        }
    }

    @GetMapping("/all")
    public List<OrderDto> allOrder(){
        log.info("Handling find all order request");
        return orderService.findAllOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>  orderById(@PathVariable Long id) {
        try {
            log.info("Handling get order request: " + id);
            return ResponseEntity.ok(orderService.findByIdOrder(id));
        } catch (OrderNotFoundException e) {
            return ResponseEntity.badRequest().body("An error has occurred!!!");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateOrder(@PathVariable Long id, @RequestBody Order order)  {
        try {
            log.info("Handling update order request: " + id);
            orderService.updateOrder(id,order);
            return ResponseEntity.ok("Order has been successfully updated!");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("An error has occurred!!!");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>  deleteOrder(@PathVariable Long id){
        try {
            log.info("Handling delete order request: " + id);
            orderService.deleteByIdOrder(id);
            return ResponseEntity.ok("Order successfully deleted");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("An error has occurred!!!");
        }
    }
}
