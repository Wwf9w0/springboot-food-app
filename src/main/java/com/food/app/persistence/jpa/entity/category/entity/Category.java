package com.food.app.persistence.jpa.entity.category.entity;

import com.food.app.persistence.jpa.entity.product.entity.Product;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue
    private Long id;

    private String categoryName;
}
