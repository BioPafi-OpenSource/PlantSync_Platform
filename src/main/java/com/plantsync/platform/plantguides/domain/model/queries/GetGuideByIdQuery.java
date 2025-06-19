package com.plantsync.platform.plantguides.domain.model.queries;

public record GetGuideByIdQuery(Long guideId) {

    public GetGuideByIdQuery {
        if (guideId == null || guideId <= 0) throw new IllegalArgumentException("Guide id is required.");
    }

}
