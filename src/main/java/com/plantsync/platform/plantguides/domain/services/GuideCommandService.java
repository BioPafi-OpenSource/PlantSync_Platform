package com.plantsync.platform.plantguides.domain.services;

import com.plantsync.platform.plantguides.domain.model.commands.CreateGuideCommand;

public interface GuideCommandService {



Long handle(CreateGuideCommand command);

}
