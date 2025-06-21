package com.plantsync.platform.plantprofiles.infrastructure.persistence.jpa.repositories;

import com.plantsync.platform.plantprofiles.domain.model.aggregates.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantRepository extends JpaRepository<Plant,Long> {


    List<Plant> findByUserId(Long userId);


}
