package com.plantsync.platform.iam.domain.model.queries;

import com.plantsync.platform.iam.domain.model.valueobjects.Roles;

public record GetRoleByNameQuery(Roles name) {
}
