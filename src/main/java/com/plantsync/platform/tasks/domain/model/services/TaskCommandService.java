package com.plantsync.platform.tasks.domain.model.services;

import com.plantsync.platform.plantprofiles.domain.model.commands.CreatePlantCommand;
import com.plantsync.platform.plantprofiles.domain.model.commands.DeletePlantCommand;

public interface TaskCommandService {


    Long handle(CreatePlantCommand command);

    void handle(DeletePlantCommand command);

}

