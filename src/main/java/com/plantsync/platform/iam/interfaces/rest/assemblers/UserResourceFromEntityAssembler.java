package com.plantsync.platform.iam.interfaces.rest.assemblers;

import com.plantsync.platform.iam.domain.model.aggregates.User;
import com.plantsync.platform.iam.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User user) {

        return new UserResource(
                user.getId(),
                user.getEmail());
    }
}