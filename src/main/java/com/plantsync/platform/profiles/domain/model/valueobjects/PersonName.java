package com.plantsync.platform.profiles.domain.model.valueobjects;


public record PersonName(String name) {

    public PersonName() {
        this( null);
    }

    public PersonName {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Last name must not be null or blank");
        }
    }
}