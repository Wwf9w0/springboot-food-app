package com.food.app.persistence.jpa.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "order")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private BigDecimal totalPrice;

    @Column
    private String note;
   /* @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<ItemQuantity> items;*/
   /* @ManyToOne( fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private UserInfo userInfo;*/
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProductEntity> products;

/*
    public UserInfo getUserInfo(){
        return userInfo;
    }
*/
}
