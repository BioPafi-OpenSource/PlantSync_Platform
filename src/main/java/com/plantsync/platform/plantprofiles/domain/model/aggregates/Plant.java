package com.plantsync.platform.plantprofiles.domain.model.aggregates;

import com.plantsync.platform.plantprofiles.domain.model.commands.CreatePlantCommand;
import com.plantsync.platform.plantprofiles.domain.model.valueobjects.ProfileId;
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
    @AttributeOverride(name = "value", column = @Column(name = "plant_name"))
    private PlantName name;

    private String species;

    private LocalDate acquisitionDate;

    @Enumerated(EnumType.STRING)
    private HumidityLevel humidity;

    private LocalDate nextWateringDate;

    private String imageUrl;

    private Boolean notificationsEnabled;

    @Embedded
    private ProfileId profileId;

    public Plant(){

    }

    public Plant(CreatePlantCommand command) {
       this.name = new PlantName(command.name());
       this.species = command.species();
       this.acquisitionDate = LocalDate.parse(command.acquisitionDate());
       this.humidity = HumidityLevel.valueOf(command.humidity().toUpperCase());
       this.nextWateringDate = LocalDate.parse(command.nextWateringDate());
        this.imageUrl = command.imageUrl();
        this.notificationsEnabled = command.notificationsEnabled();
        this.profileId = new ProfileId(command.profileId());


    }


    public Plant updateInformation(PlantName name,
                                   String species,
                                   LocalDate acquisitionDate,
                                   HumidityLevel humidity,
                                   LocalDate nextWateringDate,
                                   String imageUrl,
                                   Boolean notificationsEnabled,
                                   ProfileId profileId

                                   ) {

        this.name = name;
        this.species = species;
        this.acquisitionDate = acquisitionDate;
        this.humidity = humidity;
        this.nextWateringDate = nextWateringDate;
        this.imageUrl = imageUrl;
        this.notificationsEnabled = notificationsEnabled;
        this.profileId = profileId;


        return this;
    }

}
