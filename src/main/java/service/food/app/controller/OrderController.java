package service.food.app.controller;

import service.food.app.Service.OrderService;
import service.food.app.persistence.jpa.entity.OrderEntity;
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
    public ResponseEntity<OrderEntity> save(@RequestBody OrderEntity order){
        OrderEntity o = orderService.save(order);
        return ResponseEntity.ok(o);
    }

    @GetMapping("/orders")
    @ApiOperation("List of Orders")
    public ResponseEntity<List<OrderEntity>> getOrders(){
        List<OrderEntity> orderList = orderService.getOrders();
        return ResponseEntity.ok(orderList);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("Delete Order")
    public ResponseEntity<OrderEntity> deleteOrder(@PathVariable("id") Long id){
        orderService.deleteOrderById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<OrderEntity> getOrderById(@PathVariable("id") Long id){
        Optional<OrderEntity> optionalOrder = orderService.getOrderById(id);
        return ResponseEntity.ok(optionalOrder.get());
    }


}
