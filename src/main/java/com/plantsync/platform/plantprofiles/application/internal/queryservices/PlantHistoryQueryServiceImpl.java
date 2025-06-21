package com.plantsync.platform.plantprofiles.application.internal.queryservices;

import com.plantsync.platform.plantprofiles.domain.exceptions.PlantHistoryNotFoundException;
import com.plantsync.platform.plantprofiles.domain.model.aggregates.PlantHistory;
import com.plantsync.platform.plantprofiles.domain.model.queries.GetPlantHistoryByPlantIdQuery;
import com.plantsync.platform.plantprofiles.domain.services.PlantHistoryQueryService;
import com.plantsync.platform.plantprofiles.infrastructure.persistence.jpa.repositories.PlantHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class PlantHistoryQueryServiceImpl implements PlantHistoryQueryService
{

    private final PlantHistoryRepository plantHistoryRepository;

    public PlantHistoryQueryServiceImpl(PlantHistoryRepository plantHistoryRepository) {
        this.plantHistoryRepository = plantHistoryRepository;
    }


    @Override
    public Optional<PlantHistory> handle(GetPlantHistoryByPlantIdQuery query) {
        if (!plantHistoryRepository.existsById(query.plantId())) throw new PlantHistoryNotFoundException(query.plantId());
        return plantHistoryRepository.findById(query.plantId());
    }


}
