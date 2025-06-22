package com.plantsync.platform.plantguides.domain.services;

import com.plantsync.platform.plantguides.domain.model.aggregates.Guide;
import com.plantsync.platform.plantguides.domain.model.queries.GetAllGuidesQuery;
import com.plantsync.platform.plantguides.domain.model.queries.GetGuideByIdQuery;

import java.util.List;
import java.util.Optional;


public interface GuideQueryService {



List<Guide> handle(GetAllGuidesQuery query);

Optional<Guide> handle(GetGuideByIdQuery query);

}
