package service.food.app.persistence.jpa.repository;

import service.food.app.persistence.jpa.entity.CampaignEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignRepository extends JpaRepository<CampaignEntity, Long> {
}
