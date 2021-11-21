package com.food.app.persistence.jpa.entity.product.entity;

import com.food.app.persistence.jpa.entity.category.entity.Category;
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
    private String title;
    private BigDecimal price;
    private String description;
    private String saleInformation;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Category category;

}
