package com.plantsync.platform.profiles.application.internal.commandservices;


import com.plantsync.platform.profiles.domain.exceptions.ProfileNotFoundException;
import com.plantsync.platform.profiles.domain.exceptions.ProfileUpdateException;
import com.plantsync.platform.profiles.domain.model.aggregates.Profile;
import com.plantsync.platform.profiles.domain.model.commands.CreateProfileCommand;
import com.plantsync.platform.profiles.domain.model.commands.UpdateProfileCommand;
import com.plantsync.platform.profiles.domain.model.valueobjects.PersonName;
import com.plantsync.platform.profiles.domain.model.valueobjects.SubscriptionPlan;
import com.plantsync.platform.profiles.domain.services.ProfileCommandService;
import com.plantsync.platform.profiles.infrastructure.persistence.jpa.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileCommandServiceImpl implements ProfileCommandService {
    private final ProfileRepository profileRepository;

    /**
     * Constructor
     *
     * @param profileRepository The {@link ProfileRepository} instance
     */
    public ProfileCommandServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    // inherited javadoc
    @Override
    public Optional<Profile> handle(CreateProfileCommand command) {

        var profile = new Profile(command);
        profileRepository.save(profile);
        return Optional.of(profile);
    }


    @Override
    public Optional<Profile> handle(UpdateProfileCommand command) {
        var result = profileRepository.findById(command.id());

        if (result.isEmpty())
            throw new IllegalArgumentException("Profile is empty");
        var profileToUpdate = result.get();

        try {
            var updatedProfile = profileRepository.save(
                    profileToUpdate.updateInformation(
                            new PersonName(command.personName()),
                            SubscriptionPlan.valueOf(command.subscriptionPlan().toUpperCase())
                    )
            );
            return Optional.of(updatedProfile);
        } catch (Exception e) {
            throw new ProfileUpdateException(e.getMessage());
        }
    }


}