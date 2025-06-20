package com.plantsync.platform.plantprofiles.domain.model.commands;

public record CreatePlantCommand (

         String name,

         String species,

         String acquisitionDate,

         String humidity,

        String nextWateringDate,

        String imageUrl,

        Boolean notificationsEnabled,

        Long profileId


) {

    public CreatePlantCommand {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("title cannot be null or blank");
        }
        if (species == null || species.isBlank()) {
            throw new IllegalArgumentException("description cannot be null or blank");
        }
    }
}