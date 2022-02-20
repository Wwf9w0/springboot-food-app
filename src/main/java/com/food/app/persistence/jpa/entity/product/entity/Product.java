package com.food.app.persistence.jpa.entity.product.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.food.app.persistence.jpa.entity.category.entity.Category;
import com.food.app.persistence.jpa.entity.order.entity.Order;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "product")
@RequiredArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String productName;
    private BigDecimal price;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JsonBackReference
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Category category;

}
