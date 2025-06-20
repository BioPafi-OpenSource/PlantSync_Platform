package com.plantsync.platform.plantprofiles.interfaces.rest.assemblers;

import com.plantsync.platform.plantprofiles.domain.model.commands.CreatePlantCommand;
import com.plantsync.platform.plantprofiles.interfaces.rest.resources.CreatePlantResource;

public class CreatePlantCommandFromResourceAssembler {


        public static CreatePlantCommand toCommandFromResource(CreatePlantResource resource) {

            return new CreatePlantCommand(
                       resource.name(),
                    resource.species(),
                    resource.acquisitionDate(),
                    resource.humidity(),
                    resource.nextWateringDate(),
                    resource.imageUrl(),
                    resource.notificationsEnabled(),
                    resource.profileId());
    }

}