package com.food.app.persistence.jpa.repository;

import com.food.app.persistence.jpa.entity.CampaignEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignRepository extends CrudRepository<CampaignEntity, Long> {
}
