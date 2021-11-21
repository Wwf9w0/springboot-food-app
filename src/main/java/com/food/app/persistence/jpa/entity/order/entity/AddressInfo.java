package com.food.app.persistence.jpa.entity.order.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "addressinfo")
public class AddressInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private UserInfo userInfo;
}
