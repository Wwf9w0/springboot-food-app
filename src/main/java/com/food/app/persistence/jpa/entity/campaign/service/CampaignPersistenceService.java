package com.food.app.persistence.jpa.entity.campaign.service;

import com.food.app.persistence.jpa.entity.campaign.entity.Campaign;
import com.food.app.persistence.jpa.entity.campaign.repository.CampaignRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CampaignPersistenceService {

    private final CampaignRepository campaignRepository;

    public List<Campaign> getAllCategory(){
        return (List<Campaign>) campaignRepository.findAll();
    }

    public Optional<Campaign> getCategoryById(Long id){
        return campaignRepository.findById(id);
    }

    public void deleteCategory(Long id){
        campaignRepository.deleteById(id);
    }

}
