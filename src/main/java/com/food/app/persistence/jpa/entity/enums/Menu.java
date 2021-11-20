package com.food.app.persistence.jpa.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Menu {

    HAMBURGER(1),
    PIZZA(2);

    private final int type;
}
