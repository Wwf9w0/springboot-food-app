package com.food.app.persistence.jpa.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CategoryType {

        FOOD(1),
        DRINK(2);

        private final int type;

}
