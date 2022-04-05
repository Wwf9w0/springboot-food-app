package service.food.app.Service;

import service.food.app.persistence.jpa.converter.CampaignConverter;
import service.food.app.persistence.jpa.dto.CampaignDto;
import service.food.app.persistence.jpa.entity.CampaignEntity;
import service.food.app.persistence.jpa.service.CampaignPersistenceService;
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
        List<CampaignEntity> campaignEntities = campaignPersistenceService.getAllCampaign();
        return campaignConverter.toCampaignDtoList(campaignEntities);
    }
}
