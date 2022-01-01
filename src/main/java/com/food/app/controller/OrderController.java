package com.food.app.controller;

import com.food.app.Service.OrderService;
import com.food.app.persistence.jpa.entity.order.entity.Order;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/create/order")
    @ApiOperation("Create Order")
    public ResponseEntity<Order> save(@RequestBody Order order){
        Order o = orderService.save(order);
        return ResponseEntity.ok(o);
    }

    @GetMapping("/orders")
    @ApiOperation("List of Orders")
    public ResponseEntity<List<Order>> getOrders(){
        List<Order> orderList = orderService.getOrders();
        return ResponseEntity.ok(orderList);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("Delete Order")
    public ResponseEntity<Order> deleteOrder(@PathVariable("id") Long id){
        orderService.deleteOrderById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") Long id){
        Optional<Order> optionalOrder = orderService.getOrderById(id);
        return ResponseEntity.ok(optionalOrder.get());
    }


}
