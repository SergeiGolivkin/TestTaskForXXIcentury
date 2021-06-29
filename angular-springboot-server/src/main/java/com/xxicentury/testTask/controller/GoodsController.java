package com.xxicentury.testTask.controller;

import com.xxicentury.testTask.dto.GoodsDto;
import com.xxicentury.testTask.entity.Goods;
import com.xxicentury.testTask.exception.GoodsNotFoundException;
import com.xxicentury.testTask.service.GoodsService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/goods")
@AllArgsConstructor
@Log
public class GoodsController {

    private final GoodsService goodsService;

    @PostMapping("/add")
    public ResponseEntity<?> addGoods(@RequestBody GoodsDto goodsDto){
        try {
            goodsService.saveGoods(goodsDto);
            log.info("Handling save goods: " + goodsDto);
            return ResponseEntity.ok("Goods successfully saved");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("An error has occurred!!!");
        }
    }

    @GetMapping("/all")
    public List<GoodsDto> allGoods(){
        log.info("Handling find all goods request");
        return goodsService.findAllGoods();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>  goodsById(@PathVariable Long id) {
        try {
            log.info("Handling get goods request: " + id);
            return ResponseEntity.ok(goodsService.findByIdGoods(id));
        } catch (GoodsNotFoundException e) {
            return ResponseEntity.badRequest().body("An error has occurred!!!");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateGoods(@PathVariable Long id, @RequestBody Goods goods)  {
        try {
            log.info("Handling update goods request: " + id);
            goodsService.updateGoods(id,goods);
            return ResponseEntity.ok("Goods has been successfully updated!");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("An error has occurred!!!");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>  deleteGoods(@PathVariable Long id){
        try {
            log.info("Handling delete goods request: " + id);
            goodsService.deleteGoods(id);
            return ResponseEntity.ok("Goods successfully deleted");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("An error has occurred!!!");
        }
    }

}
