package com.food.app.persistence.jpa.entity.order.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.food.app.persistence.jpa.entity.product.entity.Product;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal totalPrice;
    private String note;
   /* @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<ItemQuantity> items;*/
   /* @ManyToOne( fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private UserInfo userInfo;*/
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Product> products;

/*
    public UserInfo getUserInfo(){
        return userInfo;
    }
*/
}
