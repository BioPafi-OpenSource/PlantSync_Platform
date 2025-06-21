package com.plantsync.platform.plantprofiles.application.internal.queryservices;


import com.plantsync.platform.plantprofiles.domain.model.aggregates.Plant;
import com.plantsync.platform.plantprofiles.domain.model.queries.GetAllPlantsByUserIdQuery;
import com.plantsync.platform.plantprofiles.domain.model.queries.GetAllPlantsQuery;
import com.plantsync.platform.plantprofiles.domain.model.queries.GetPlantByIdQuery;
import com.plantsync.platform.plantprofiles.domain.services.PlantQueryService;
import com.plantsync.platform.plantprofiles.infrastructure.persistence.jpa.repositories.PlantRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@Service
public class PlantQueryServiceImpl implements PlantQueryService {


    private final PlantRepository plantRepository;

    public PlantQueryServiceImpl(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    @Override
    public List<Plant> handle(GetAllPlantsQuery query) {
        return plantRepository.findAll();
    }

    @Override
    public List<Plant> handle(GetAllPlantsByUserIdQuery query) {
        return plantRepository.findByUserId(query.userId());
    }

    @Override
    public Optional<Plant> handle(GetPlantByIdQuery query) {
        return plantRepository.findById(query.plantId());
    }



}
