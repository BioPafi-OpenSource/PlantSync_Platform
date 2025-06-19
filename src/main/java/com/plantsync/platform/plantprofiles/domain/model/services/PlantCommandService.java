package com.plantsync.platform.plantprofiles.domain.model.services;

import com.plantsync.platform.plantguides.domain.model.commands.CreateGuideCommand;

public interface PlantCommandService {



    public interface GuideCommandService {

        
        Long handle(CreateGuideCommand command);

    }


}
