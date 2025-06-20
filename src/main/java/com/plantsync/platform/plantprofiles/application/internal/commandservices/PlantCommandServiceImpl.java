package com.plantsync.platform.plantprofiles.application.internal.commandservices;

import com.plantsync.platform.plantguides.domain.model.aggregates.Guide;
import com.plantsync.platform.plantprofiles.domain.model.aggregates.Plant;
import com.plantsync.platform.plantprofiles.domain.model.commands.CreatePlantCommand;
import com.plantsync.platform.plantprofiles.domain.model.commands.DeletePlantCommand;
import com.plantsync.platform.plantprofiles.domain.model.services.PlantCommandService;
import com.plantsync.platform.plantprofiles.infrastructure.persistence.jpa.repositories.PlantRepository;
import org.springframework.stereotype.Service;

@Service
public class PlantCommandServiceImpl implements PlantCommandService {

    private final PlantRepository plantRepository;

    public PlantCommandServiceImpl(PlantRepository plantRepository) {

        this.plantRepository = plantRepository;
    }


    @Override
    public Long handle(CreatePlantCommand command) {
        var plant = new Plant(command);
        try {
            plantRepository.save(plant);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error saving plant: %s".formatted(e.getMessage()));
        }
        return plant.getId();


    }


    @Override
    public void handle(DeletePlantCommand command) {
        if (!plantRepository.existsById(command.plantId())) {
            throw new IllegalArgumentException("Plant with id %s not found".formatted(command.plantId()));
        }
        try {
            plantRepository.deleteById(command.plantId());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while deleting plant: %s".formatted(e.getMessage()));
        }
    }




}
