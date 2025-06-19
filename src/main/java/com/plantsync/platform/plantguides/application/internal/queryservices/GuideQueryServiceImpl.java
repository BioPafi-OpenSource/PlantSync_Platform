package com.plantsync.platform.plantguides.application.internal.queryservices;

import com.plantsync.platform.plantguides.domain.model.queries.GetAllGuidesQuery;
import com.plantsync.platform.plantguides.domain.model.queries.GetGuideByIdQuery;
import com.plantsync.platform.plantguides.domain.services.GuideQueryService;
import com.plantsync.platform.plantguides.infrastructure.persistence.jpa.repositories.GuideRepository;
import com.plantsync.platform.plantguides.domain.model.aggregates.Guide;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class GuideQueryServiceImpl implements GuideQueryService {
    private final GuideRepository guideRepository;

    public GuideQueryServiceImpl(GuideRepository guideRepository) {
        this.guideRepository = guideRepository;
    }

    @Override
    public List<Guide> handle(GetAllGuidesQuery query) {
        return guideRepository.findAll();
    }

    @Override
    public Optional<Guide> handle(GetGuideByIdQuery query) {
        return guideRepository.findById(query.guideId());
    }




}
