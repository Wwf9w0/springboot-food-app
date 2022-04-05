package service.food.app.persistence.jpa.converter;

import service.food.app.persistence.jpa.dto.CampaignDto;
import service.food.app.persistence.jpa.entity.CampaignEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CampaignConverter {

    public CampaignDto toCampaignDto(CampaignEntity campaignEntity){
        return CampaignDto.builder()
                .id(campaignEntity.getId())
                .campaignName(campaignEntity.getCampaignName())
                .description(campaignEntity.getDescription())
                .campaignEndDate(campaignEntity.getCampaignEndDate())
                .campaignStartDate(campaignEntity.getCampaignStartDate())
                .build();
    }


    public List<CampaignDto> toCampaignDtoList(List<CampaignEntity> campaignEntities){
        return campaignEntities.stream().map( campaignEntity -> CampaignDto.builder()
                .id(campaignEntity.getId())
                .campaignName(campaignEntity.getCampaignName())
                .campaignStartDate(campaignEntity.getCampaignStartDate())
                .campaignEndDate(campaignEntity.getCampaignEndDate())
                .description(campaignEntity.getDescription())
                .build()).collect(Collectors.toList());
    }
}
