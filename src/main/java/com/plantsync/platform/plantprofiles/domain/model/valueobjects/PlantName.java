package com.plantsync.platform.plantprofiles.domain.model.valueobjects;
import jakarta.persistence.Embeddable;



@Embeddable
public record PlantName(String value) {

    /**
     * Default constructor for JPA
     */
    public PlantName() {
        this(null);
    }

    /**
     * Canonical constructor with validation
     */
    public PlantName {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Plant name must not be null or blank");
        }
        if (value.length() > 100) {
            throw new IllegalArgumentException("Plant name must not exceed 100 characters");
        }
    }


}
