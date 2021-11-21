package com.food.app.persistence.jpa.entity.order.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String restaurantId;
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<ItemQuantity> items;
    private BigDecimal totalPrice;
    private Long orderTime;
    private String speialNote;
    private Long deliveryTime;
    private String paymentId;
    private String note;

    @ManyToOne( fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private UserInfo userInfo;

    public UserInfo getUserInfo(){
        return userInfo;
    }
}
