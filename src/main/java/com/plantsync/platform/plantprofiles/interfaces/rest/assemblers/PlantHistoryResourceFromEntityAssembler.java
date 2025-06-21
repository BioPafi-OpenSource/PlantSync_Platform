package com.plantsync.platform.plantprofiles.interfaces.rest.assemblers;

import com.plantsync.platform.plantprofiles.domain.model.aggregates.PlantHistory;
import com.plantsync.platform.plantprofiles.interfaces.rest.resources.PlantHistoryResource;



public class PlantHistoryResourceFromEntityAssembler{

public static PlantHistoryResource toResourceFromEntity(PlantHistory entity){

    return new PlantHistoryResource(
            entity.getId(),
            entity.getPlant().getId(),
            entity.getType(),
            entity.getDate().toString(),
            entity.getTime().toString(),
            entity.getHumidity()

    );
}



}
