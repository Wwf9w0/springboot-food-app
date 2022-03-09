package com.food.app.persistence.jpa.service;

import com.food.app.persistence.jpa.entity.CampaignEntity;
import com.food.app.persistence.jpa.repository.CampaignRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CampaignPersistenceService {

    private final CampaignRepository campaignRepository;

    public List<CampaignEntity> getAllCampaign(){
        return (List<CampaignEntity>) campaignRepository.findAll();
    }

    public Optional<CampaignEntity> getCategoryById(Long id){
        return campaignRepository.findById(id);
    }

    public void deleteCategory(Long id){
        campaignRepository.deleteById(id);
    }

    public CampaignEntity createCampaign(CampaignEntity campaign){
        return campaignRepository.save(campaign);
    }
}
