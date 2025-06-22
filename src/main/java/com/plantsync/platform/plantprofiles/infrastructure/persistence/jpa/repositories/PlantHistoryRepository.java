package com.plantsync.platform.plantprofiles.infrastructure.persistence.jpa.repositories;

import com.plantsync.platform.plantprofiles.domain.model.aggregates.PlantHistory;
import com.plantsync.platform.plantprofiles.domain.model.valueobjects.PlantId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlantHistoryRepository extends JpaRepository<PlantHistory, Long> {
    List<PlantHistory> findByPlantId(PlantId plantId);
}