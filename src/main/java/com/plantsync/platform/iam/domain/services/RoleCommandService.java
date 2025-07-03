package com.plantsync.platform.iam.domain.services;

import com.plantsync.platform.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}
