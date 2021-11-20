package com.food.app.persistence.jpa.service;

import com.food.app.persistence.jpa.entity.Campaign;
import com.food.app.persistence.jpa.entity.Category;
import com.food.app.persistence.jpa.repository.CampaignRepository;
import com.food.app.persistence.jpa.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CampaignService {

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
