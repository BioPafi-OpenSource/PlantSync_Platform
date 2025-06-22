package com.plantsync.platform.plantprofiles.domain.model.queries;

import com.plantsync.platform.plantprofiles.domain.model.valueobjects.PlantId;

public record GetAllPlantHistoriesByPlantIdQuery(PlantId plantId) {
}
