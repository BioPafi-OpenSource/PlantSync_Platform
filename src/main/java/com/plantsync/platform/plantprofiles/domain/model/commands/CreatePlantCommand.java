package com.plantsync.platform.plantprofiles.domain.model.commands;


public record CreatePlantCommand (

        String title,
        String name,
        String description,
        String topic,
        String type,
        String imageUrl

) {

    public CreatePlantCommand {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title cannot be null or blank");
        }
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("description cannot be null or blank");
        }
    }
}