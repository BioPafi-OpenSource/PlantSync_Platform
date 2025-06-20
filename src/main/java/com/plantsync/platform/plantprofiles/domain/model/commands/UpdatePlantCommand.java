package com.plantsync.platform.plantprofiles.domain.model.commands;


import com.plantsync.platform.plantprofiles.domain.model.valueobjects.HumidityLevel;
import com.plantsync.platform.plantprofiles.domain.model.valueobjects.PlantName;

import java.time.LocalDate;

public record UpdatePlantCommand(
        Long plantId,
        PlantName name,
        String species,
        LocalDate acquisitionDate,
        HumidityLevel humidity,
        LocalDate nextWateringDate,
        String imageUrl,
        Boolean notificationsEnabled,
        Long userId
) {
    public UpdatePlantCommand {


    }
}
