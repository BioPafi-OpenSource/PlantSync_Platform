package com.plantsync.platform.tasks.domain.model.aggregates;


import com.plantsync.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.plantsync.platform.tasks.domain.model.commands.CreateTaskCommand;
import com.plantsync.platform.tasks.domain.model.valueobjects.PlantId;

import com.plantsync.platform.tasks.domain.model.valueobjects.ProfileId;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Task extends AuditableAbstractAggregateRoot<Task> {

    @NotNull
    private LocalDate date;

    @NotBlank
    private String action;

    @NotNull
    private Boolean completed;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "plant_id"))
    private PlantId plantId;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "profile_id"))
    private ProfileId profileId;

    public Task() {}


    public Task(CreateTaskCommand command) {
        this.date = command.date();
    this.action = command.action();
        this.completed = command.completed();
    this.plantId = command.plantId();
    this.profileId = command.profileId();

    }


    public Task updateInformation(

    String action,
    LocalDate date,
    PlantId plantId,
    ProfileId profileId,
    Boolean completed
    ) {

        this.action = action;
        this.date = date;
        this.plantId = plantId;
        this.profileId = profileId;
        this.completed = completed;



        return this;
    }
    
    
    
    
}