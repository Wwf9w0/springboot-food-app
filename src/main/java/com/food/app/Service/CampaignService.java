package com.food.app.Service;

import com.food.app.persistence.jpa.converter.CampaignConverter;
import com.food.app.persistence.jpa.dto.CampaignDto;
import com.food.app.persistence.jpa.entity.campaign.entity.Campaign;
import com.food.app.persistence.jpa.entity.campaign.service.CampaignPersistenceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CampaignService {

    private final CampaignPersistenceService campaignPersistenceService;
    private final CampaignConverter campaignConverter;

    public List<CampaignDto> getAllCampaign(){
        List<Campaign> campaigns = campaignPersistenceService.getAllCampaign();
        return campaignConverter.toCampaignDtoList(campaigns);
    }
}
