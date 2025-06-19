package com.plantsync.platform.plantguides.application.internal.commandservices;

import com.plantsync.platform.plantguides.domain.model.aggregates.Guide;
import com.plantsync.platform.plantguides.domain.model.commands.CreateGuideCommand;
import com.plantsync.platform.plantguides.domain.services.GuideCommandService;
import com.plantsync.platform.plantguides.infrastructure.persistence.jpa.repositories.GuideRepository;
import org.springframework.stereotype.Service;

@Service
public class GuideCommandServiceImpl implements GuideCommandService {

private final GuideRepository guideRepository;

public GuideCommandServiceImpl(GuideRepository guideRepository) {

    this.guideRepository = guideRepository;
}


    @Override
    public Long handle(CreateGuideCommand command) {
        var guide = new Guide(command);
        try {
            guideRepository.save(guide);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error saving guide: %s".formatted(e.getMessage()));
        }
        return guide.getId();


    }

}
