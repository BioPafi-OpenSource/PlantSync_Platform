package com.plantsync.platform.iam.interfaces.rest.resources;

public record AuthenticatedUserResource(Long id, String email, String token) {
}
