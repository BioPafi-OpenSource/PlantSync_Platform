package com.plantsync.platform.profiles.infrastructure.persistence.jpa.repositories;

import com.plantsync.platform.profiles.domain.model.aggregates.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
}