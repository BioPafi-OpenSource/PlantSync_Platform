package com.plantsync.platform.iam.interfaces.rest.transform;


import com.plantsync.platform.iam.domain.model.commands.SignUpCommand;
import com.plantsync.platform.iam.domain.model.entities.Role;
import com.plantsync.platform.iam.domain.model.valueobjects.Roles;
import com.plantsync.platform.iam.interfaces.rest.resources.SignUpResource;

import java.util.*;

public class SignUpCommandFromResourceAssembler {
    public static SignUpCommand toCommandFromResource(SignUpResource resource) {
        return new SignUpCommand(
                resource.name(),

                resource.password(),
                List.of(new Role(Roles.ROLE_USER)), // o lo que definas por defecto
                resource.email(),
                resource.subscriptionPlan()
        );
    }
}
