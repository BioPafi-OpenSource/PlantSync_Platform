package com.plantsync.platform.plantprofiles.domain.model.queries;

import com.plantsync.platform.plantprofiles.domain.model.valueobjects.ProfileId;

public record GetAllPlantsByProfileIdQuery(ProfileId profileId) {
}
