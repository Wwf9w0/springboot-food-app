package com.food.app.persistence.jpa.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CampaignType {


    NEW_MEMBER(1),
    GOLD_MEMBER(2);

    private final int type;
}
