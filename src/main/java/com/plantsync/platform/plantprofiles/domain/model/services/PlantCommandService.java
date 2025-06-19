package com.plantsync.platform.plantprofiles.domain.model.services;

import com.plantsync.platform.plantguides.domain.model.commands.CreateGuideCommand;
import com.plantsync.platform.plantprofiles.domain.model.commands.CreatePlantCommand;

public interface PlantCommandService {




        Long handle(CreatePlantCommand command);




}
