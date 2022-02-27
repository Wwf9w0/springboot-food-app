package com.food.app.persistence.jpa.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CampaignDto {

    private Long id;
    private String campaignName;
    private String description;
    private String campaignStartDate;
    private String campaignEndDate;
}
