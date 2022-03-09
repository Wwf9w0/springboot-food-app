package com.food.app.persistence.jpa.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "campaign")
@RequiredArgsConstructor
public class CampaignEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String campaignName;
    private String description;
    private String campaignStartDate;
    private String campaignEndDate;
}
