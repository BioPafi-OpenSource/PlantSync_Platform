package com.plantsync.platform.plantprofiles.domain.model.aggregates;

import com.plantsync.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.plantsync.platform.plantprofiles.domain.model.valueobjects.PlantName;
import com.plantsync.platform.plantprofiles.domain.model.valueobjects.HumidityLevel;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Plant extends AuditableAbstractAggregateRoot<Plant> {

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "name"))
    private PlantName name;

    private String species;

    private LocalDate acquisitionDate;

    @Enumerated(EnumType.STRING)
    private HumidityLevel humidity;

    private LocalDate nextWateringDate;

    private String imageUrl;

    private Boolean notificationsEnabled;

    private Long userId;

    public Plant(){

    }




}
