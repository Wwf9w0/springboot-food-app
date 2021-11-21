package com.food.app.persistence.jpa.entity.campaign.repository;

import com.food.app.persistence.jpa.entity.campaign.entity.Campaign;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignRepository extends CrudRepository<Campaign, Long> {
}
