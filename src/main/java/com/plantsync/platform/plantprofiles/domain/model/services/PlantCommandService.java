package com.plantsync.platform.plantprofiles.domain.model.services;

import com.plantsync.platform.plantprofiles.domain.model.commands.CreatePlantCommand;
import com.plantsync.platform.plantprofiles.domain.model.commands.DeletePlantCommand;

public interface PlantCommandService {




        Long handle(CreatePlantCommand command);

        void handle(DeletePlantCommand command);



}
