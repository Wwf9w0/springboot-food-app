package com.food.app.persistence.jpa.entity.campaign.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "campaign")
@RequiredArgsConstructor
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String campaignName;
    private String description;
    private String campaignStartDate;
    private String campaignEndDate;
}
