package com.plantsync.platform.iam.application.internal.commandservices;

import com.plantsync.platform.iam.domain.model.aggregates.User;
import com.plantsync.platform.iam.domain.model.commands.SignInCommand;
import com.plantsync.platform.iam.domain.model.commands.SignUpCommand;
import com.plantsync.platform.iam.domain.services.UserCommandService;
import com.plantsync.platform.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import com.plantsync.platform.profiles.domain.model.aggregates.Profile;
import com.plantsync.platform.profiles.domain.model.valueobjects.PersonName;
import com.plantsync.platform.profiles.domain.model.valueobjects.SubscriptionPlan;
import com.plantsync.platform.profiles.domain.model.valueobjects.UserId;
import com.plantsync.platform.profiles.infrastructure.persistence.jpa.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;

    public UserCommandServiceImpl(UserRepository userRepository,
                                  ProfileRepository profileRepository) {
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
    }

    @Override
    public Optional<User> handle(SignInCommand command) {
        var user = userRepository.findByEmail(command.email());
        if (user.isEmpty())
            throw new RuntimeException("User not found");

        return user;
    }

    @Override
    public Optional<User> handle(SignUpCommand command) {
        if (userRepository.existsByEmail(command.email()))
            throw new RuntimeException("Username already exists");

        var user = new User(command.email(), command.password());
        userRepository.save(user);

        var profile = new Profile(
                new PersonName(command.name()),
                SubscriptionPlan.valueOf(command.subscriptionPlan().toUpperCase()),
                new UserId(user.getId())
        );
        profileRepository.save(profile);



        return Optional.of(user);
    }
}

