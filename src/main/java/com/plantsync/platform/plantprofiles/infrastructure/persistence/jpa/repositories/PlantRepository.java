package com.plantsync.platform.plantprofiles.infrastructure.persistence.jpa.repositories;

import com.plantsync.platform.plantprofiles.domain.model.aggregates.Plant;
import com.plantsync.platform.plantprofiles.domain.model.valueobjects.ProfileId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlantRepository extends JpaRepository<Plant,Long> {


    List<Plant> findByProfileId(Long profileId);


}
