package com.food.app.persistence.jpa.entity.restaurant.entity;

import com.food.app.persistence.jpa.entity.product.entity.Product;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "restaurant")
@Builder
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String city;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private Set<Product> products;
}
