package com.food.app.persistence.jpa.entity;

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
public class RestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String city;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private Set<ProductEntity> products;
}
