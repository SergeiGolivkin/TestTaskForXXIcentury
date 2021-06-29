package com.xxicentury.testTask.controller;


import com.xxicentury.testTask.dto.OrderLineDto;
import com.xxicentury.testTask.entity.OrderLine;
import com.xxicentury.testTask.exception.OrderLineNotFoundException;
import com.xxicentury.testTask.service.OrderLineService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/order-line")
@AllArgsConstructor
@Log
public class OrderLineController {

    private final OrderLineService orderLineService;


    @PostMapping("/add")
    public ResponseEntity<?> addOrderLine(@RequestBody OrderLineDto orderLineDto){
        try {
            orderLineService.saveOrderLine(orderLineDto);
            log.info("Handling save orderLine: " + orderLineDto);
            return ResponseEntity.ok("OrderLine successfully saved");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error has occurred!!!");
        }
    }

    @GetMapping("/all")
    public List<OrderLineDto> allOrderLine(){
        log.info("Handling find all orderLine request");
        return orderLineService.findAllOrderLine();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>  orderLineById(@PathVariable Long id) {
        try {
            log.info("Handling get orderLine request: " + id);
            return ResponseEntity.ok(orderLineService.findByIdOrderLine(id));
        } catch (OrderLineNotFoundException e) {
            return ResponseEntity.badRequest().body("An error has occurred!!!");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateOrderLine(@PathVariable Long id, @RequestBody OrderLine orderLine)  {
        try {
            log.info("Handling update orderLine request: " + id);
            orderLineService.updateOrderLine(id,orderLine);
            return ResponseEntity.ok("OrderLine has been successfully updated!");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("An error has occurred!!!");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>  deleteOrderLine(@PathVariable Long id){
        try {
            log.info("Handling delete orderLine request: " + id);
            orderLineService.deleteByIdOrderLine(id);
            return ResponseEntity.ok("OrderLine successfully deleted");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("An error has occurred!!!");
        }
    }

}
