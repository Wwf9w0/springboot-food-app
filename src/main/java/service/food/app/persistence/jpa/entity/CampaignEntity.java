package service.food.app.persistence.jpa.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "campaign")
@RequiredArgsConstructor
public class CampaignEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String campaignName;

    @Column
    private String description;

    @Column
    private String campaignStartDate;

    @Column
    private String campaignEndDate;
}
