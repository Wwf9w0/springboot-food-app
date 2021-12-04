package com.food.app.Service;

import com.food.app.persistence.jpa.entity.order.service.OrderPersistenceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final OrderPersistenceService orderPersistenceService;



}
