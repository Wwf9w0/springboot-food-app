package com.food.app.persistence.jpa.converter;

import com.food.app.persistence.jpa.dto.CampaignDto;
import com.food.app.persistence.jpa.entity.campaign.entity.Campaign;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class CampaignConverter {

    public static CampaignDto toCampaignDto(Campaign campaign){
        return CampaignDto.builder()
                .id(campaign.getId())
                .campaignName(campaign.getCampaignName())
                .description(campaign.getDescription())
                .campaignEndDate(campaign.getCampaignEndDate())
                .campaignStartDate(campaign.getCampaignStartDate())
                .build();
    }


    public List<CampaignDto> toCampaignDtoList(List<Campaign> campaigns){
        return campaigns.stream().map(CampaignConverter::toCampaignDto)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
