package com.plantsync.platform.tasks.interfaces.rest.assemblers;

import com.plantsync.platform.plantprofiles.domain.model.aggregates.Plant;
import com.plantsync.platform.plantprofiles.interfaces.rest.resources.PlantResource;
import com.plantsync.platform.tasks.domain.model.aggregates.Task;
import com.plantsync.platform.tasks.interfaces.rest.resources.TaskResource;

import java.time.LocalDate;

public class TaskResourceFromEntityAssembler{

    public static TaskResource toResourceFromEntity(Task entity){

        return new TaskResource(
                entity.getId(),
                entity.getAction(),
                entity.getDate().toString(),
                entity.getPlantId().value(),
                entity.getProfileId().value(),
                entity.getCompleted()

        );
    }





}
