package com.plantsync.platform.plantprofiles.domain.model.aggregates;

import com.plantsync.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
public class PlantHistory extends AuditableAbstractAggregateRoot<PlantHistory> {

    @ManyToOne
    @JoinColumn(name = "plant_id")
    private Plant plant;

    private String type;
    private LocalDate date;
    private LocalTime time;
    private Integer humidity;

    public PlantHistory(){

    }
}
